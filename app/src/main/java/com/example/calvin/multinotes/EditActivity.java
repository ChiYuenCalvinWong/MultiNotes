package com.example.calvin.multinotes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private EditText title;
    private EditText content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);

        Intent intent = getIntent();
        if(intent.hasExtra("TITLE")){
            title.setText(intent.getStringExtra("TITLE"));
        }
        if(intent.hasExtra("CONTENT")){
            content.setText(intent.getStringExtra("CONTENT"));
        }
        //getIntent from Main
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save:
                //goto async task
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //go back without save
    @Override
    public void onBackPressed() {
        if(!title.getText().toString().equals("") && !content.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //save to JSON, change data in noteList;
                    return;
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditActivity.this.finish();
                }
            });

            builder.setTitle("Your note is not saved!");
            //if new note just show new title, else show old title from mainActivity
            builder.setMessage("Save note " + "'" + title.getText() + "'");

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
