package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView btnBack;
    private ImageButton btnSettings;
    private TextView tvProfileName;
    private TextView tvFriendsCount;
    private TextView tvFollowersCount;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvSkype;
    private TextView tvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo views
        btnBack = findViewById(R.id.btnBack);
        btnSettings = findViewById(R.id.btnSettings);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvFriendsCount = findViewById(R.id.tvFriendsCount);
        tvFollowersCount = findViewById(R.id.tvFollowersCount);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb);

        // Nhận dữ liệu từ LoginActivity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Hiển thị tên profile
        if (username != null && !username.isEmpty()) {
            tvProfileName.setText(username);
        }

        tvFriendsCount.setText("125");
        tvFollowersCount.setText("250");
        tvEmail.setText("mail@email.com");
        tvPhone.setText("+99 999 555 222");
        tvSkype.setText("me007");
        tvWeb.setText("scsauthor.com/");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại màn hình Login
                finish();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý nút Back của hệ thống (cách mới)
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }
}