package com.example.fight_corona;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
              this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_reorder_black_24dp);

        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment1 = new Home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment1);
       // ft.addToBackStack(null);
        ft.commit();





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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.live_data)
        {
            displaySelectedScreen(R.id.live_data);

        } else if (id == R.id.genpass)
        {
            displaySelectedScreen(R.id.genpass);
        } else if (id == R.id.no)
        {
            displaySelectedScreen(R.id.no);
        } else if (id == R.id.prec)
        {
            displaySelectedScreen(R.id.prec);
        } else if (id == R.id.donation)
        {
            displaySelectedScreen(R.id.donation);
        } else if (id == R.id.mypass)
        {
            displaySelectedScreen(R.id.mypass);
        }
        else if (id == R.id.mass)
        {
            displaySelectedScreen(R.id.mass);
        }


        return true;
    }



    private void displaySelectedScreen(int itemId) {


        Fragment fragment = null;
        switch (itemId) {
            case R.id.live_data:
                fragment = new Home();
                break;
            case R.id.genpass:
                fragment=new genpass();

                break;
            case R.id.no:
                fragment=new helpline();
                break;

            case R.id.prec:
                fragment=new prec();
                break;

            case R.id.donation:
                fragment=new donation();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
