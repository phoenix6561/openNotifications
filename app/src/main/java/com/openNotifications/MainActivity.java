package com.openNotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.openNotifications.notification.dao.NotificationDAO;
import com.openNotifications.notification.model.Notification;
import com.openNotifications.notification.service.NotificationUpdateService;
import com.openNotifications.notification.service.NotificationViewService;
import com.openNotifications.notification.view.NotificationRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NotificationDAO notificationDAO;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Notification> notifications = new ArrayList<Notification>();
private NotificationUpdateService notificationUpdateService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // notificationViewService = new NotificationViewService("0",this);
        viewSetup();

        notificationUpdateService = new NotificationUpdateService(this, "main" , mAdapter ,recyclerView ,notifications);
        //  updateNotifications();





    }

    private void viewSetup() {
        notificationDAO = new NotificationDAO(this);
        recyclerView = (RecyclerView) findViewById(R.id.fragmentView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new NotificationRecyclerViewAdapter(notifications);
        recyclerView.setAdapter(mAdapter);
    }


}