package com.xan.mynavigation;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class Banner extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

        SliderLayout sliderLayout;
        HashMap<String,String> Hash_file_maps ;

@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_banner);

        Hash_file_maps = new HashMap<String, String>();

        sliderLayout = (SliderLayout)findViewById(R.id.slider);

        Hash_file_maps.put("Android CupCake", "http://androidblog.esy.es/images/cupcake-1.png");
        Hash_file_maps.put("Beautiful","https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjZoPKB-P7jAhXTjOYKHTs5DKsQjRx6BAgBEAQ&url=http%3A%2F%2Fexpresstricks.com%2Fwhat-are-some-beautiful-lines-to-comment-on-beautiful-pictures-best-comments-for-beautiful-pics%2F&psig=AOvVaw0BJL5U-e0kQW_5A0ayw1H_&ust=1565754287145940");
        Hash_file_maps.put("Wallpaper","https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjpv7S89_7jAhUV6XMBHYRwDiAQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.technocrazed.com%2F45-hd-beautiful-wallpapersbackgrounds-for-free-download&psig=AOvVaw0BJL5U-e0kQW_5A0ayw1H_&ust=1565754287145940");
        Hash_file_maps.put("Android Donut", "http://androidblog.esy.es/images/donut-2.png");
        Hash_file_maps.put("Android Eclair", "http://androidblog.esy.es/images/eclair-3.png");
        Hash_file_maps.put("Android Froyo", "http://androidblog.esy.es/images/froyo-4.png");
        Hash_file_maps.put("Android GingerBread", "http://androidblog.esy.es/images/gingerbread-5.png");

        for(String name : Hash_file_maps.keySet()){

        TextSliderView textSliderView = new TextSliderView(Banner.this);
        textSliderView
        .description(name)
        .image(Hash_file_maps.get(name))
        .setScaleType(BaseSliderView.ScaleType.Fit)
        .setOnSliderClickListener(this);
        textSliderView.bundle(new Bundle());
        textSliderView.getBundle()
        .putString("extra",name);
        sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);
        }
@Override
protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
        }

@Override
public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
        }

@Override
public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

@Override
public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);
        }

@Override
public void onPageScrollStateChanged(int state) {}
        }

