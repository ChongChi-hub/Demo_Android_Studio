package com.example.demotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Hàm này tương ứng với android:onClick="showToast" trong XML
    public void showToast(View view) {
        Toast.makeText(this, "This is a Toast", Toast.LENGTH_SHORT).show(); //
    }
}