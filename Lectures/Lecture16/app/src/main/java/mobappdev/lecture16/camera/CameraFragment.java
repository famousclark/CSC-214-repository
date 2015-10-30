package mobappdev.lecture16.camera;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mobappdev.lecture16.FullScreenPhotoActivity;
import mobappdev.lecture16.PhotoUtils;
import mobappdev.lecture16.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {
    private static final String TAG = "CameraFragment";

    private File mPhotoFile;
    private List<File> mPhotoFiles;
    private PhotoAdapter mPhotoAdapter;

    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        mPhotoFiles = new ArrayList<>();
        RecyclerView list = (RecyclerView)view.findViewById(R.id.recycler_view_photos);
        list.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mPhotoAdapter = new PhotoAdapter(mPhotoFiles);
        list.setAdapter(mPhotoAdapter);

        Button buttonPhoto = (Button)view.findViewById(R.id.button_photo);
        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeAPhoto();
            }
        });

        return view;
    }

    public void takeAPhoto() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        //make a random filename
        String filename = "IMG_" + UUID.randomUUID().toString() + ".jpg";
        //make a file in the external photos directory
        File picturesDir =
                getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        mPhotoFile = new File(picturesDir, filename);

        Uri photoUri = Uri.fromFile(mPhotoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

        Log.d(TAG, "photo location: " + mPhotoFile.toString());

        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");
        if(resultCode == Activity.RESULT_OK) {
            mPhotoFiles.add(mPhotoFile);
            mPhotoAdapter.setPhotoFiles(mPhotoFiles);
        }
    }

    public void displayImage() {
        if(mPhotoFile != null) {
            Intent intent = FullScreenPhotoActivity.newIntent(getActivity(),
                    mPhotoFile.getPath());
            startActivity(intent);
        }
    }

    /**
     * Created by USX13992 on 10/30/2015.
     */
    private class PhotoHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public PhotoHolder(ImageView itemView) {
            super(itemView);
            mImageView = itemView;
        }

        public void bind(File photoFile) {
            if(photoFile != null && photoFile.exists()) {
                Bitmap photo = PhotoUtils.getScaledBitmap(photoFile.getPath(),
                        mImageView.getWidth(), mImageView.getHeight());
                mImageView.setImageBitmap(photo);
            }
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

        private List<File> mPhotoFiles;

        PhotoAdapter(List<File> photoFiles) {
            mPhotoFiles = photoFiles;
        }

        public void setPhotoFiles(List<File> photoFiles) {
            mPhotoFiles = photoFiles;
            notifyDataSetChanged();
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ImageView view = (ImageView)inflater.inflate(R.layout.view_photo, parent, false);
            return new PhotoHolder(view);
        }

        @Override
        public void onBindViewHolder(PhotoHolder holder, int position) {
            holder.bind(mPhotoFiles.get(position));
        }

        @Override
        public int getItemCount() {
            return mPhotoFiles.size();
        }
    }
}
