package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner season, week;
    String[] daysOfWeek = {"Monday" , "Tuesday" ,"Wednesday" ,"Thursday" ,"Friday" ,"Saturday" ,"Sunday"   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        season = findViewById(R.id.seasonSpinner);
        week = findViewById(R.id.weekSpinner);

        //Create from recourse - yəni xml-də tanımlanan veriləri çəkmək üçün
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.seasonName, android.R.layout.simple_spinner_item);
        season.setAdapter(arrayAdapter);

        //new ArrayAdapter - isə Javada verilən dosyaları çəkmək
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,daysOfWeek);
        week.setAdapter(arrayAdapter1);

        season.setOnItemSelectedListener(this);
        week.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView textView = (TextView) view;
        Toast.makeText(this,"You clicked: " + textView.getText() ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}