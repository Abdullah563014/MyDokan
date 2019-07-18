package com.github.abdullah563014.mydokan.showdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.github.abdullah563014.mydokan.R;

public class ShowDetails extends AppCompatActivity {

    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
