package com.example.demotogglebutton;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến
    ToggleButton toggleButton;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        toggleButton = findViewById(R.id.toggleButton);
        linearLayout = findViewById(R.id.linearLayout);

        // Bắt sự kiện khi ToggleButton thay đổi trạng thái
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    // Nếu trạng thái là ON (true) -> Nền xanh lá
                    linearLayout.setBackgroundColor(Color.GREEN);
                } else {
                    // Nếu trạng thái là OFF (false) -> Nền đỏ
                    linearLayout.setBackgroundColor(Color.RED);
                }
            }
        });
    }
}