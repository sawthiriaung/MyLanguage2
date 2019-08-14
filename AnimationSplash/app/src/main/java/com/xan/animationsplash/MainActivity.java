package com.xan.animationsplash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rotate = (Button) findViewById(R.id.rotate);
        Button ltoR = (Button) findViewById(R.id.ltoR);
    }

    public void onClickRotate(View v)
    {
        Intent i = new Intent(getApplicationContext(), RotateSplash.class);
        startActivity(i);
        finish();
    }

    public void onClickltoR(View v)
    {
        Intent i = new Intent(getApplicationContext(), LtoRSplash.class);
        startActivity(i);
        finish();
    }

    public void onClickShake(View v)
    {
        Intent i = new Intent(getApplicationContext(), ShakeSplash.class);
        startActivity(i);
        finish();
    }
}
