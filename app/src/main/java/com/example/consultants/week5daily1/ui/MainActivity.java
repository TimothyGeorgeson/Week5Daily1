package com.example.consultants.week5daily1.ui;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consultants.week5daily1.R;
import com.example.consultants.week5daily1.data.EmployeesProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "ID";
            String channelTitle = "TITLE";
            String channelDesc = "DESC";
            NotificationChannel channel = new NotificationChannel(channelId,
                    channelTitle, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDesc);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void addEmployee(View view) {
        // Add a new employee record
        ContentValues values = new ContentValues();
        values.put(EmployeesProvider.FIRSTNAME,
                ((EditText)findViewById(R.id.etFirstName)).getText().toString());

        values.put(EmployeesProvider.LASTNAME,
                ((EditText)findViewById(R.id.etLastName)).getText().toString());

        values.put(EmployeesProvider.SALARY,
                ((EditText)findViewById(R.id.etSalary)).getText().toString());

        values.put(EmployeesProvider.DAYS,
                ((EditText)findViewById(R.id.etDays)).getText().toString());

        getContentResolver().insert(
                EmployeesProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                "Record Added Successfully", Toast.LENGTH_LONG).show();
    }
    public void displayEmployees(View view) {
        //intent to show second screen with employee list
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }

}
