package com.nmh.speaktotext.myfirstmvvm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.nmh.speaktotext.myfirstmvvm.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.nmh.speaktotext.myfirstmvvm.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.nmh.speaktotext.myfirstmvvm.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.nmh.speaktotext.myfirstmvvm.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY,1));
        }else{
            setTitle("Add Note");
        }
        setTitle("Add Note");
    }

    private void saveNote(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please Enter title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
       data.putExtra(EXTRA_TITLE, title);
       data.putExtra(EXTRA_DESCRIPTION,description);
       data.putExtra(EXTRA_PRIORITY,priority);

       int id = getIntent().getExtra(EXTRA_ID, -1);
       if (id != -1){
           data.putExtra(EXTRA_ID, id) ;
       }


       setResult(RESULT_OK,data);
       finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
