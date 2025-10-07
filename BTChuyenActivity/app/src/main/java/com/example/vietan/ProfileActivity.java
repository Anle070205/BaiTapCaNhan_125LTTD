package com.example.vietan;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.content.Intent;

public class ProfileActivity extends AppCompatActivity {

    private ImageView btnSettings;
    private ImageView btnBack;
    private TextView tvProfileName;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvSkype;
    private TextView tvWeb;
    private TextView tvFriendsCount;
    private TextView tvFollowersCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Khởi tạo views
        btnSettings = findViewById(R.id.btnSettings);
        btnBack = findViewById(R.id.btnBack);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb);
        tvFriendsCount = findViewById(R.id.tvFriendsCount);
        tvFollowersCount = findViewById(R.id.tvFollowersCount);

        // Nhận dữ liệu từ LoginActivity
        String username = getIntent().getStringExtra("USERNAME");
        boolean rememberMe = getIntent().getBooleanExtra("REMEMBER_ME", false);

        // Hiển thị thông tin profile
        if (username != null && !username.isEmpty()) {
            displayProfileInfo(username);
        } else {
            // Nếu không có username, hiển thị thông tin mặc định
            tvProfileName.setText("Guest User");
            tvEmail.setText("guest@mail.com");
            tvPhone.setText("+84 " + generateRandomPhone());
            tvSkype.setText("guest007");
            tvWeb.setText("guest.com");
        }

        // Xử lý click Settings để quay về Login
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay về Login và clear stack
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý click Back - chỉ finish activity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void displayProfileInfo(String username) {
        // Hiển thị tên profile
        tvProfileName.setText(username);

        // Tạo email từ username
        String email = username.toLowerCase().replaceAll("\\s+", "") + "@mail.com";
        tvEmail.setText(email);

        // Tạo số điện thoại ngẫu nhiên
        tvPhone.setText("+84 " + generateRandomPhone());

        // Tạo Skype ID từ username
        String skypeId = username.toLowerCase().replaceAll("\\s+", "");
        tvSkype.setText(skypeId);

        // Tạo website từ username
        String website = username.toLowerCase().replaceAll("\\s+", "") + ".com";
        tvWeb.setText(website);

        // Hiển thị số Friends và Followers (có thể random hoặc fix)
        tvFriendsCount.setText(String.valueOf(generateRandomCount(50, 500)));
        tvFollowersCount.setText(String.valueOf(generateRandomCount(100, 1000)));
    }

    // Hàm tạo số điện thoại ngẫu nhiên
    private String generateRandomPhone() {
        Random random = new Random();
        int part1 = random.nextInt(900) + 100; // 100-999
        int part2 = random.nextInt(900) + 100; // 100-999
        int part3 = random.nextInt(900) + 100; // 100-999
        return String.format("%03d %03d %03d", part1, part2, part3);
    }

    // Hàm tạo số ngẫu nhiên cho Friends/Followers
    private int generateRandomCount(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}