package com.example.demowebview; // Thay bằng package name của bạn

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        editText = findViewById(R.id.editText);
        webView = findViewById(R.id.webView);

        // Cài đặt WebViewClient để web mở ngay trong ứng dụng (không bị văng ra trình duyệt ngoài)
        webView.setWebViewClient(new WebViewClient());
    }

    // Nút Back: Quay lại trang trước đó
    public void backButton(View view) {
        if(webView.canGoBack()) {
            webView.goBack();
        }
    }

    // Nút Forward: Tiến tới trang tiếp theo
    public void fwdButton(View view) {
        if(webView.canGoForward()) {
            webView.goForward();
        }
    }

    // Nút Reload: Tải lại trang hiện tại
    public void reloadButton(View view) {
        webView.reload();
    }

    // Nút Go: Lấy URL từ EditText và tải trang
    public void goBack(View view) {
        String url = editText.getText().toString();
        // Cải tiến nhỏ: Tự động thêm http:// nếu người dùng quên nhập
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        webView.loadUrl(url);
    }
}