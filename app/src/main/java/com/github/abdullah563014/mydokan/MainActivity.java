package com.github.abdullah563014.mydokan;

import android.content.Intent;
import android.os.Bundle;

import com.github.abdullah563014.mydokan.Utils.Utils;
import com.github.abdullah563014.mydokan.database.Task;
import com.github.abdullah563014.mydokan.dataentry.DataEntryActivity;
import com.github.abdullah563014.mydokan.adapter.RecyclerAdapter;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.widget.Toast;

import com.github.abdullah563014.mydokan.showdetails.ShowDetails;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    RecyclerView recyclerView;
    public static List<Task> list=new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initializeAll();

        setupNavigationDrawer();

        setupRecyclerView();

        Utils.LoadDataAsyncTask loadDataAsyncTask=new Utils.LoadDataAsyncTask(this);
        loadDataAsyncTask.execute();

    }


    private void initializeAll(){
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        recyclerView=findViewById(R.id.mainActivityRecyclerViewId);

    }

    private void setupNavigationDrawer(){
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void setupRecyclerView(){
        recyclerAdapter=new RecyclerAdapter(this,list);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickListner(new RecyclerAdapter.OnItemClickListner() {
            @Override
            public void onClick(Task task) {
                Intent intent=new Intent(MainActivity.this, ShowDetails.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_gallery) {
            Intent dataEntryIntent=new Intent(MainActivity.this, DataEntryActivity.class);
            startActivity(dataEntryIntent);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    protected void onResume() {
        if (recyclerAdapter!=null){
            recyclerAdapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
