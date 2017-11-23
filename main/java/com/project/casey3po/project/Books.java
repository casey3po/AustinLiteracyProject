package com.project.casey3po.project;

import android.provider.BaseColumns;

/**
 * Created by Casey3po on 11/18/2017.
 */

public class Books {

    private Books() {}

    public class BookInfo implements BaseColumns
    {
        public static final String TABLE_NAME = "mybooks";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_TITLE = "title";
    }

}
