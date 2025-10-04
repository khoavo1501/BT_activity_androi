package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvLostPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Khởi tạo views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvLostPassword = findViewById(R.id.tvLostPassword);

        // Xử lý sự kiện click nút Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Kiểm tra validation
                if (username.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng nhập username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng nhập password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Đăng nhập thành công - chuyển sang màn hình Profile
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);

                // Hiển thị thông báo thành công
                Toast.makeText(LoginActivity.this,
                        "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý sự kiện Lost Password
        tvLostPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,
                        "Chức năng đang được phát triển", Toast.LENGTH_SHORT).show();
            }
        });
    }
}