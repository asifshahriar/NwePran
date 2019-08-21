package com.example.myproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class owner_activity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button;
    String phone = "01710604515";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_activity);

        imageView = findViewById(R.id.ownerimageViewId);
        textView = findViewById(R.id.ownerTextViewId);

        button = findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone ,null));
                startActivity(intent);
            }
        });

    }
}
