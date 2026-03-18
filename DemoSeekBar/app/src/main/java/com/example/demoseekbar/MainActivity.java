package com.example.demoseekbar;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến
    SeekBar seekBar; //
    TextView textView; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        seekBar = findViewById(R.id.seekBar); //
        textView = findViewById(R.id.textView); //

        // Viết code xử lý sự kiện thay đổi của thanh trượt
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //

            // Hàm này chạy liên tục khi bạn đang kéo thanh trượt
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Cập nhật giá trị "i" (từ 0 đến 100) lên TextView
                textView.setText("Value:" + i); //
            }

            // Hàm này chạy khi bạn vừa chạm tay vào thanh trượt
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Để trống theo code mẫu
            }

            // Hàm này chạy khi bạn thả tay khỏi thanh trượt
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Để trống theo code mẫu
            }
        });
    }
}