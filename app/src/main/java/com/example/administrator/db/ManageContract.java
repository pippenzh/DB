package com.example.administrator.db;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 2015/7/28.
 */
public final class ManageContract {
    public ManageContract() {}

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static  final String COLUMN_NAME_NAME = "name";
        public static  final String COLUMN_NAME_PHONE = "phone";
    }
}
