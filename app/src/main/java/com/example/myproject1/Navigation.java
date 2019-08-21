package com.example.myproject1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import java.security.acl.Owner;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private CardView member, locaton, advice, owner, bteb, institute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        //card view

        //find variable
        member = findViewById(R.id.memberId);
        locaton = findViewById(R.id.locationId);
        advice = findViewById(R.id.rulesId);
        owner = findViewById(R.id.ownerId);
        bteb = findViewById(R.id.btebId);
        institute = findViewById(R.id.instituteId);

        //set onClick listener
        member.setOnClickListener(this);
        locaton.setOnClickListener(this);
        advice.setOnClickListener(this);
        owner.setOnClickListener(this);
        bteb.setOnClickListener(this);
        institute.setOnClickListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this,Navigation.class);
            startActivity(intent);
        } else if (id == R.id.nav_member) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_rules) {
            Intent intent = new Intent(this,RulesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_owner) {
            Intent intent = new Intent(this, owner_activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.memberId){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(view.getId()== R.id.locationId){
            Intent intent = new Intent(this, GoogleMap_Activity.class);
            startActivity(intent);
        }else if(view.getId()== R.id.rulesId){
            Intent intent = new Intent(this, RulesActivity.class);
            startActivity(intent);
        }else if(view.getId()== R.id.ownerId){
            Intent intent = new Intent(this, owner_activity.class);
            startActivity(intent);
        }else if(view.getId()== R.id.btebId){
            Intent intent = new Intent(this, Bteb.class);
            startActivity(intent);
        }else if(view.getId()== R.id.instituteId){
            Intent intent = new Intent(this, institute.class);
            startActivity(intent);
        }
    }
}
