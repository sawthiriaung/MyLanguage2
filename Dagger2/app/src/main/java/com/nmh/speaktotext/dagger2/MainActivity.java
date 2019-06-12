package com.nmh.speaktotext.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       CarComponent component = DaggerCarComponent.create();
       component.inject(this);
//       car = component.getCar();
        car.drive();
    }
}
