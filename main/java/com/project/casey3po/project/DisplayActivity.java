package com.project.casey3po.project;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends MainActivity {

    private DBAdapter bookDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        bookDB = new DBAdapter(this);
        bookDB.open();
        Cursor c = bookDB.getAllTitles();
        TextView text = (TextView) findViewById(R.id.table);

        StringBuilder builder = new StringBuilder();
        if (c.moveToFirst()) {
            builder.append("TITLE: " + c.getString(0) + "\n" +
                    "AUTHOR: " + c.getString(1) + "\n\n");
        } else {
            builder.append("no records found");
        }
        while (c.moveToNext())
        {
            builder.append("TITLE: " + c.getString(0) + "\n" +
                    "AUTHOR: " + c.getString(1) + "\n\n");
        }

        text.setText(builder);
    }
}
