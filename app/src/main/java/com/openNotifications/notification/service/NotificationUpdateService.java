package com.openNotifications.notification.service;

import android.content.Context;

import com.openNotifications.notification.dao.NotificationDAO;
import com.openNotifications.notification.model.Notification;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class NotificationUpdateService {

    Context context;
    NotificationDAO notificationDAO;
    NotificationViewService notificationViewService;
    private List<Notification> notifications ;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView recyclerView;
    private RestService restService;


    public NotificationUpdateService(Context context , String channelId , RecyclerView.Adapter mAdapter,RecyclerView recyclerView ,List<Notification> notifications){
        this.context = context;
        this.notificationDAO = new NotificationDAO(context);
        notificationViewService = new NotificationViewService(channelId,context,channelId);
        this.restService = new RestService(context);
        this.mAdapter = mAdapter;
        this.recyclerView = recyclerView;
        this.notifications = notifications;
    }

    private void processNewNotification(Notification notification){


        notificationDAO.insertNotification(notification);
        notifications.add(notification);
        mAdapter.notifyDataSetChanged();
        notificationViewService.showNotification(notification.getTitle(),notification.getText(),notification.getId());

    }




}
