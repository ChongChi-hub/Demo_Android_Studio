package com.example.demogridviewadvanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class PictureActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        imageView = findViewById(R.id.imageView);

        // Nhận dữ liệu truyền sang
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if (bundle != null) {
            HinhAnh hinhAnh = (HinhAnh) bundle.getSerializable("ha");
            if (hinhAnh != null) {
                imageView.setImageResource(hinhAnh.getHinh());
            }
        }
    }

    // Sự kiện quay lại màn hình chính (Dùng cho thuộc tính android:onClick bên XML)
    public void BackActivity(View view) {
        finish();
    }
}