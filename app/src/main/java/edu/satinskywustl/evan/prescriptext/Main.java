package edu.satinskywustl.evan.prescriptext;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.SecureRandom;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;

public class Main extends AppCompatActivity {

    Button btnpic;
    ImageView imgTakenPic;
    private static final int CAM_REQUEST=1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpic = (Button) findViewById(R.id.button);
        imgTakenPic = (ImageView)findViewById(R.id.imageView);
        btnpic.setOnClickListener(new btnTakePhotoClicker());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

//            Mat mat = new Mat();
//            Bitmap bmp32 = bmp.copy(Bitmap.Config.ARGB_8888, true);
//            Utils.bitmapToMat(bmp32, mat);
            imgTakenPic.setImageBitmap(bitmap);
        }
    }

    class btnTakePhotoClicker implements  Button.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAM_REQUEST);
        }
    }
}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button b = (Button) findViewById(R.id.button);
////        b.OnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
////                startActivityForResult(intent, 0);
////            }
////        });
//    }

//}


