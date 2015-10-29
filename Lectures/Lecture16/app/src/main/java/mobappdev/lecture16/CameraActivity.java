package mobappdev.lecture16;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.UUID;

public class CameraActivity extends AppCompatActivity {

    private static final String TAG = "CameraActivity";
    private ImageView mPhoto;
    private File mPhotoFile;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CameraActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mPhoto = (ImageView)findViewById(R.id.image_button_photo);
    }

    public void takeAPhoto(View view) {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        //make a random filename
        String filename = "IMG_" + UUID.randomUUID().toString() + ".jpg";
        //make a file in the external photos directory
        File picturesDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        mPhotoFile = new File(picturesDir, filename);

        Uri photoUri = Uri.fromFile(mPhotoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);

        Log.d(TAG, "photo location: " + mPhotoFile.toString());

        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");
        if(resultCode == Activity.RESULT_OK) {
            updatePhoto();
        }
    }

    private void updatePhoto() {
        if(mPhotoFile == null || mPhotoFile.exists() == false) {
            Log.d(TAG, "Photo doesn't exist at: " + mPhotoFile.getPath());
            mPhoto.setImageDrawable(null);
        }
        else {
            Log.d(TAG, "Photo exists!");
            Bitmap photo = PhotoUtils.getScaledBitmap(mPhotoFile.getPath(),
                    mPhoto.getWidth(), mPhoto.getHeight());
            mPhoto.setImageBitmap(photo);
            mPhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void displayImage(View view) {
        Intent intent = FullScreenPhotoActivity.newIntent(this, mPhotoFile.getPath());
        startActivity(intent);

    }
}
