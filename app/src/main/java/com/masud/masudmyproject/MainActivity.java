package com.masud.masudmyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    MaterialCardView cardView,noticeDeleteCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.noticeActivity);

        noticeDeleteCard = findViewById(R.id.noticeDeleteCardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noticeIntent = new Intent(MainActivity.this,NoticeActivity.class);
                startActivity(noticeIntent);
            }
        });

        noticeDeleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DeleteNoticeActivity.class));
            }
        });
    }
}