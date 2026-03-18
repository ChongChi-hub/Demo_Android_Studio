package com.example.demoedittext;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến
    EditText editText; //
    Button button; //
    TextView textView; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        editText = findViewById(R.id.editText); //
        button = findViewById(R.id.button); //
        textView = findViewById(R.id.textView); //

        // Bắt sự kiện click cho Button
        button.setOnClickListener(new View.OnClickListener() { //
            @SuppressLint("SetTextI18n") //
            @Override
            public void onClick(View view) { //
                // Lấy dữ liệu người dùng nhập
                String username = editText.getText().toString(); //

                // Hiển thị ra màn hình kèm chữ Welcome
                // Thêm một khoảng trắng sau chữ "Welcome " để chữ không bị dính liền nhau nhé
                textView.setText("Welcome " + username); //
            }
        }); //
    }
}