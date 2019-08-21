package com.example.myproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    String[] memberNames, memberDesc,memberDetails, phoneNumber;
    private int[] images = {R.drawable.abdus_sobahan_sarkar, R.drawable.asif, R.drawable.halim,R.drawable.jabbarul_islam, R.drawable.limon,R.drawable.md_abdur_rahman_shuvo,R.drawable.md_ayatul_islam_ayatn,R.drawable.rasel,R.drawable.rs_rasel_mia,R.drawable.shadiduzzaman_mondol,R.drawable.tanvir};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add back button
        //adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //actionbar color
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));
        //Action ber logo
        //getSupportActionBar().setLogo(R.drawable.friendship);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        //find id
        recyclerView = findViewById(R.id.recycleViewId);

        //get String
        memberNames = getResources().getStringArray(R.array.member_names);
        memberDesc = getResources().getStringArray(R.array.subTitle);
        memberDetails = getResources().getStringArray(R.array.details);
        phoneNumber = getResources().getStringArray(R.array.phone_array);

        MyAdapter myAdapter = new MyAdapter(this,memberNames,memberDesc,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int i, View v) {

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("AllName",memberNames[i]);
                intent.putExtra("images",images[i]);
                intent.putExtra("desc",memberDesc[i]);
                intent.putExtra("details",memberDetails[i]);
                intent.putExtra("phone",phoneNumber[i]);

                startActivity(intent);


            }
        });


    }
    //add bac button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
