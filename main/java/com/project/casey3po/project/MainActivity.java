package com.project.casey3po.project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Casey3po on 11/20/2017.
 * This application allows the user to save and view books they have read, as well as view Austin Public
 * Library locations.
 * Uses SQLiteDatabase and MediaPlayer.
 */

public class MainActivity extends AppCompatActivity {

    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBAdapter(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemID = item.getItemId();

        switch (itemID) {
            case (R.id.about_nav):
                Intent aboutIntent = new Intent(this, About.class);
                startActivity(aboutIntent);
                MediaPlayer mediaAbout = MediaPlayer.create(this, R.raw.pageflip1);
                mediaAbout.start();
                return true;

            case (R.id.reads):
                Intent nearestIntent = new Intent(this, DisplayActivity.class);
                startActivity(nearestIntent);
                MediaPlayer mediaReads = MediaPlayer.create(this, R.raw.pageflip2);
                mediaReads.start();
                return true;

            case (R.id.nearest):
                Intent readIntent = new Intent(this, MapsActivity.class);
                startActivity(readIntent);
                MediaPlayer mediaNearest = MediaPlayer.create(this, R.raw.pageflip3);
                mediaNearest.start();
                return true;

            case (R.id.add):
                Intent addIntent = new Intent(this, MainActivity.class);
                startActivity(addIntent);
                MediaPlayer mediaAdd = MediaPlayer.create(this, R.raw.pageflip4);
                mediaAdd.start();
                return true;
        }


        return super.onOptionsItemSelected(item);

    }

    public void addRead(View v) {
        //---add title---
        MediaPlayer mediaButton = MediaPlayer.create(this, R.raw.pageflip1);
        mediaButton.start();

        db.open();
        EditText etTitle = (EditText) findViewById(R.id.titleField);
        EditText etAuthor = (EditText) findViewById(R.id.authorField);

        long dummyID = 0;

        if (etTitle.length() == 0 || etAuthor.length() == 0) {
            Toast.makeText(this, String.format("You must enter both a title and author.",
                    dummyID), Toast.LENGTH_LONG).show();
        }
        else {
            long id = db.insertTitle(
                    etTitle.getText().toString(),
                    etAuthor.getText().toString());

        Toast.makeText(this, String.format("Added to the books you've read.", id),
                Toast.LENGTH_LONG).show();
        }
        db.close();
    }
}