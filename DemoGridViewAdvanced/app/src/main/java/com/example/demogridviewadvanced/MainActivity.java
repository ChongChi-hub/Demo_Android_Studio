package com.example.demogridviewadvanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvHinhanh;
    ArrayList<HinhAnh> arrayHinhAnh;
    HinhAnhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvHinhanh = findViewById(R.id.gvHinhanh);
        arrayHinhAnh = new ArrayList<>();

        // Thêm 9 dữ liệu mẫu
        arrayHinhAnh.add(new HinhAnh(R.drawable.android1, "Hình số 1"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android2, "Hình số 2"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android3, "Hình số 3"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android4, "Hình số 4"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android5, "Hình số 5"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android6, "Hình số 6"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android7, "Hình số 7"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android8, "Hình số 8"));
        arrayHinhAnh.add(new HinhAnh(R.drawable.android9, "Hình số 9"));

        adapter = new HinhAnhAdapter(this, R.layout.dong_hinh_anh, arrayHinhAnh);
        gvHinhanh.setAdapter(adapter);

        gvHinhanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HinhAnh hinhAnh = arrayHinhAnh.get(i);
                Intent intent = new Intent(MainActivity.this, PictureActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ha", hinhAnh);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }
}