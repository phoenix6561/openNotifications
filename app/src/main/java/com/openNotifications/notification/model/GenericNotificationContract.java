package com.openNotifications.notification.model;

import android.provider.BaseColumns;

public final class GenericNotificationContract {

    private GenericNotificationContract(){};


    public static class GenericNotification implements BaseColumns {

        public static final String TABLE_NAME = "notifications";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_TEXT = "text";


        public static String getCreateTableStatment(){
           String sql = "CREATE TABLE " + GenericNotification.TABLE_NAME + " (" +
                    GenericNotification._ID + " INTEGER PRIMARY KEY," +
                    GenericNotification.COLUMN_NAME_TITLE + " TEXT," +
                    GenericNotification.COLUMN_NAME_TEXT + " TEXT)";

            return sql;
        }

        public static String getDropTableStatment(){

            String sql =   "DROP TABLE IF EXISTS " + GenericNotification.TABLE_NAME;;

            return sql;
        }

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getColumnNameTitle() {
            return COLUMN_NAME_TITLE;
        }

        public static String getColumnNameText() {
            return COLUMN_NAME_TEXT;
        }
        public static String getColumnNameId() {
            return _ID;
        }

    }



}
