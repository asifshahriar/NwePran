package com.example.myproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView textView,textView2, descTextView,callText;
    private ImageView imageView,imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //add back button
        //getSupportActionBar().setDisplayShowHomeEnabled(true);//actionbar color
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196F3")));

        textView = findViewById(R.id.textViewIdProfile);
        textView2 = findViewById(R.id.callTextViewId);
        imageView = findViewById(R.id.imageViewIdPrifile);
        imageView2 = findViewById(R.id.callImageId);
        descTextView = findViewById(R.id.textViewDetailsId);
        callText = findViewById(R.id.callTextViewId);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            textView.setText(bundle.getString("AllName"));
            imageView.setImageResource(bundle.getInt("images"));
            descTextView.setText(bundle.getString("details"));
            callText.setText(bundle.getString("phone"));
        }
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = textView2.getText().toString();
                phone = phone.replaceAll("[^0-9]","");
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
