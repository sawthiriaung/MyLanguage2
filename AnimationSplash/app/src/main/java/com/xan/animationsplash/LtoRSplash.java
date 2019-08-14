package com.xan.animationsplash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static android.app.WallpaperManager.getInstance;

public class LtoRSplash extends AppCompatActivity {

    ImageView imageView;
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ltor_splash);

        imageView = (ImageView) findViewById(R.id.imageView1);
        Animation an2 = AnimationUtils.loadAnimation(this, R.anim.life_to_right);
        imageView.startAnimation(an2);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                if (AppStatus.getInstance(LtoRSplash.this).isOnline()) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                    //           Toast.makeText(this,"You are online!!!!",Toast.LENGTH_LONG).show();

                } else {

                    ContextThemeWrapper ctw = new ContextThemeWrapper(LtoRSplash.this, R.style.Theme_AppCompat_Dialog_Alert);
                    final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(ctw);
                    alertDialogBuilder.setTitle("No internet connection");
                    alertDialogBuilder.setMessage("Check your  internet connection or try again");
                    alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    alertDialogBuilder.show();
                }

            }
        }, SPLASH_TIME_OUT);
    }
}