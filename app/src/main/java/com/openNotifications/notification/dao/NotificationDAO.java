package com.openNotifications.notification.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.openNotifications.notification.model.GenericNotificationContract;
import com.openNotifications.notification.model.Notification;
import com.openNotifications.notification.repository.NotificationRepository;

import java.util.ArrayList;
import java.util.List;

public class NotificationDAO  {
Context context;
NotificationRepository notificationRepository;
SQLiteDatabase notificationWriteDatabase;
SQLiteDatabase notificationReadDatabase;
public NotificationDAO(Context context){

    this.context = context;
    this.notificationRepository = new NotificationRepository(context);
    notificationWriteDatabase = notificationRepository.getWritableDatabase();
    notificationReadDatabase = notificationRepository.getReadableDatabase();
}

private long insertNotification(ContentValues values){

   long newRowId = notificationWriteDatabase.insert(GenericNotificationContract.GenericNotification.getTableName(),null,values);

    return newRowId;
}

public long insertNotification(Notification notification){
    ContentValues values = new ContentValues();
values.put(GenericNotificationContract.GenericNotification.getColumnNameText(),notification.getText());
values.put(GenericNotificationContract.GenericNotification.getColumnNameTitle(),notification.getTitle());

   long newRowId = insertNotification(values);

   return newRowId;
}

public List<Notification> findAll(){
    String[] projection = {
            GenericNotificationContract.GenericNotification.getColumnNameId(),
            GenericNotificationContract.GenericNotification.getColumnNameTitle(),
            GenericNotificationContract.GenericNotification.getColumnNameText(),
            GenericNotificationContract.GenericNotification.getColumnNameService()
    };

    Cursor cursor = notificationReadDatabase.query(
            GenericNotificationContract.GenericNotification.getTableName(),   // The table to query
            projection,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
    );


    List<Notification> results= new ArrayList<Notification>();

    while(cursor.moveToNext()) {
        Notification notification = new Notification();
        notification.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(GenericNotificationContract.GenericNotification.getColumnNameTitle())));
        notification.setId(cursor.getInt(cursor.getColumnIndexOrThrow(GenericNotificationContract.GenericNotification.getColumnNameId())));
        notification.setText(cursor.getString(cursor.getColumnIndexOrThrow(GenericNotificationContract.GenericNotification.getColumnNameText())));
        notification.setServiceId(cursor.getColumnIndexOrThrow(GenericNotificationContract.GenericNotification.getColumnNameService()));


        results.add(notification);
    }
    cursor.close();

    return results;


}








}
