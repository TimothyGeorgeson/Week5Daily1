package com.example.consultants.week5daily1.ui;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.example.consultants.week5daily1.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Retrieve employee records
        String URL = "content://com.example.consultants.week5daily1.data.EmployeesProvider";

        Uri employees = Uri.parse(URL);
        Cursor c = managedQuery(employees, null, null,
                null, "firstname");

        ListView lvEmployeeList = findViewById(R.id.lvEmployeeList);
        EmployeeCursorAdapter cursorAdapter = new EmployeeCursorAdapter(this, c,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lvEmployeeList.setAdapter(cursorAdapter);
    }
}
