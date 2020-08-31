package com.openNotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.openNotifications.notification.dao.NotificationDAO;
import com.openNotifications.notification.model.Notification;
import com.openNotifications.notification.service.NotificationService;
import com.openNotifications.notification.view.NotificationRecyclerViewAdapter;
import com.openNotifications.notification.view.dummy.DummyContent;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NotificationService notificationService ;
    NotificationDAO notificationDAO;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
  private List<Notification> notifications = new ArrayList<Notification>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationService = new NotificationService("0",this);
        notificationDAO = new NotificationDAO(this);
        recyclerView = (RecyclerView) findViewById(R.id.fragmentView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new NotificationRecyclerViewAdapter(notifications);
        recyclerView.setAdapter(mAdapter);




        updateNotifications();





    }


    private void updateNotifications(){

       Notification notification = new Notification();
        notification.setText("test");
        notification.setTitle("this is a test");

        notifications.add(notification);
        mAdapter.notifyDataSetChanged();
        notificationService.showNotification(notification.getTitle(),notification.getText(),notification.getId());

    }



}