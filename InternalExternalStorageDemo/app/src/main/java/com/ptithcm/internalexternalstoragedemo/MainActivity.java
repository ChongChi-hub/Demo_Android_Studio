package com.ptithcm.internalexternalstoragedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findViewById(R.id.btnwriteIS).setOnClickListener(this);
        findViewById(R.id.btnreadIS).setOnClickListener(this);
        findViewById(R.id.btnwriteFC).setOnClickListener(this);
        findViewById(R.id.btnreadFC).setOnClickListener(this);
        findViewById(R.id.btnwriteES).setOnClickListener(this);
        findViewById(R.id.btnreadES).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnreadIS) {
            String readDataIS = readIS("myfile.txt");
            Toast.makeText(this, "Nội dung file: " + readDataIS, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnwriteIS) {
            writeIS("myfile.txt", "Xin chào các bạn!");
        } else if (id == R.id.btnreadFC) {
            String readDataFC = readFC("mycached.cache");
            Toast.makeText(this, "Data cache: " + readDataFC, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnwriteFC) {
            writeFC("mycached.cache", "Dữ liệu lưu vào cache");
        } else if (id == R.id.btnwriteES) {
            writeES("mysdcard.txt", "Dữ liệu lưu vào thẻ nhớ ngoài");
        } else if (id == R.id.btnreadES) {
            String readDataEX = readES("mysdcard.txt");
            Toast.makeText(this, "Data sdcard: " + readDataEX, Toast.LENGTH_SHORT).show();
        }
    }

    private String readIS(String filename) {
        try (FileInputStream fin = openFileInput(filename)) {
            byte[] buffer = new byte[1024];
            int length = fin.read(buffer);
            if (length != -1) {
                return new String(buffer, 0, length, StandardCharsets.UTF_8);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    private void writeIS(String filename, String data) {
        try (FileOutputStream fout = openFileOutput(filename, MODE_PRIVATE)) {
            fout.write(data.getBytes(StandardCharsets.UTF_8));
            Toast.makeText(this, "Dữ liệu đã được ghi", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private void writeFC(String filename, String data) {
        File cacheDir = getCacheDir();
        try (FileOutputStream fout = new FileOutputStream(new File(cacheDir, filename))) {
            fout.write(data.getBytes(StandardCharsets.UTF_8));
            Toast.makeText(this, "Dữ liệu lưu vào cache thành công!", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String readFC(String filename) {
        File cacheDir = getCacheDir();
        byte[] buffer = new byte[1024];
        try (FileInputStream fin = new FileInputStream(new File(cacheDir, filename))) {
            int length = fin.read(buffer);
            if (length != -1) {
                return new String(buffer, 0, length, StandardCharsets.UTF_8);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return "";
    }

    private void writeES(String filename, String data) {
        File file = new File(getExternalFilesDir(null), filename);
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            writer.write(data);
            Toast.makeText(this, "Lưu thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String readES(String filename) {
        File file = new File(getExternalFilesDir(null), filename);
        if (!file.exists()) return "";
        try (Scanner scan = new Scanner(file, StandardCharsets.UTF_8.name())) {
            StringBuilder data = new StringBuilder();
            while (scan.hasNextLine()) {
                data.append(scan.nextLine()).append("\n");
            }
            return data.toString().trim();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
