package mobappdev.lecture16;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class FullScreenPhotoActivity extends AppCompatActivity {

    private static final String EXTRA_PHOTO_PATH = "mobappdev.lecture16.photoPath";
    private ImageView mImage;

    public static Intent newIntent(Context context, String photoPath) {
        Intent intent = new Intent(context, FullScreenPhotoActivity.class);
        intent.putExtra(EXTRA_PHOTO_PATH, photoPath);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_photo);
        mImage = (ImageView)findViewById(R.id.image_view_full_screen);
        String path = getIntent().getStringExtra(EXTRA_PHOTO_PATH);
        Bitmap bitmap = PhotoUtils.getScaledBitmap(path, this);
        mImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImage.setImageBitmap(bitmap);

    }
}
