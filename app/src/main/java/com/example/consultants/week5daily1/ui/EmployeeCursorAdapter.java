package com.example.consultants.week5daily1.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.consultants.week5daily1.R;

public class EmployeeCursorAdapter extends CursorAdapter {

    public EmployeeCursorAdapter(Context context, Cursor c, int flags){
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvFirstName = view.findViewById(R.id.tvFirstName);
        TextView tvLastName = view.findViewById(R.id.tvLastName);
        TextView tvSalary = view.findViewById(R.id.tvSalary);
        TextView tvDays = view.findViewById(R.id.tvDays);
        // Extract properties from cursor
        String firstName = cursor.getString(cursor.getColumnIndexOrThrow("firstname"));
        String lastName = cursor.getString(cursor.getColumnIndexOrThrow("lastname"));
        String salary = cursor.getString(cursor.getColumnIndexOrThrow("salary"));
        String days = cursor.getString(cursor.getColumnIndexOrThrow("days"));
        // Populate fields with extracted properties
        tvFirstName.setText("First Name: " + firstName);
        tvLastName.setText("Last Name: " + lastName);
        tvSalary.setText("Salary: " + salary);
        tvDays.setText("Days Worked: " + days);
    }
}
