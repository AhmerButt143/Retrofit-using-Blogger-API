package com.example.retrofitdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
NavigationView navigationView;
DrawerLayout drawerLayout;
ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=(NavigationView)findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this,"home click",Toast.LENGTH_SHORT).show();

                    case R.id.nav_android:
                        Toast.makeText(MainActivity.this,"android click",Toast.LENGTH_SHORT).show();

                    case R.id.nav_setting:
                        Toast.makeText(MainActivity.this,"setting click",Toast.LENGTH_SHORT).show();

                    case R.id.nav_about:
                        Toast.makeText(MainActivity.this,"about us click",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });


        setUpToolbar();

        getData();
    }


    private void setUpToolbar()
    {
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle =new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }

private void getData()
{
    Call<PostList> postList = BloggerAPI.getService().getPostList();
    postList.enqueue(new Callback<PostList>() {//api response
        @Override
        public void onResponse(Call<PostList> call, Response<PostList> response) {
            PostList List=response.body();
            Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<PostList> call, Throwable t) {
            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();

        }
    });
}
}
