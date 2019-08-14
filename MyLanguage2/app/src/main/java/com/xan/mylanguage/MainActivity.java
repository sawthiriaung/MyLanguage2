package com.xan.mylanguage;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.xan.mylanguage.Helper.LocaleHelper;

import org.w3c.dom.Text;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView textView,textView2;
    Button button,button1;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this);

        textView = (TextView) findViewById(R.id.text_view);
        textView2= (TextView) findViewById(R.id.text_view1) ;
        button = (Button) findViewById(R.id.button);
        button1= (Button) findViewById(R.id.button2);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","en");

        updateView((String)Paper.book().read("language"));
    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        textView.setText(resources.getString(R.string.hello));
        textView2.setText(resources.getString(R.string.welcome));
        button.setText(resources.getString(R.string.back));
        button1.setText(resources.getString(R.string.ok));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.language_en){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else {
            if(item.getItemId() == R.id.language_my){
                Paper.book().write("language","my");
                updateView((String)Paper.book().read("language"));
            }
            else{
                if (item.getItemId()==R.id.language_ja){
                    Paper.book().write("language","ja");
                    updateView((String)Paper.book().read("language"));
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
