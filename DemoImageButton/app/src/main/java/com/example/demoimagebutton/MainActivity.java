package com.example.demoimagebutton;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        imageView = findViewById(R.id.imageView); //
    }

    // Hàm đổi sang ảnh Facebook khi bấm nút "Facebook"
    public void showFacebook(View view) { //
        imageView.setImageResource(R.drawable.facebook); //
    }

    // Hàm đổi sang ảnh Twitter khi bấm nút "Twitter"
    public void showTwitter(View view) { //
        imageView.setImageResource(R.drawable.twitter); //
    }
}