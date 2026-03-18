package com.example.cocaro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int Winer = -1;
    int startGame = 0;

    Button btPlayAgain, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    TextView txtShowresult;

    int ActivePlayer = 1;

    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btPlayAgain.setOnClickListener(v -> {
            if(startGame == 1){
                PlayAgain();
                startGame = 0;
                btPlayAgain.setText("Bắt đầu");
            } else {
                startGame = 1;
                btPlayAgain.setText("Chơi lại");
            }
        });
    }

    void AnhXa(){
        btPlayAgain = findViewById(R.id.btPlayAgain);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        txtShowresult = findViewById(R.id.txtShowresult);
    }

    public void btClick(View view){
        Button btSelected = (Button) view;
        int CellID = 0;
        int id = btSelected.getId();

        if(id == R.id.bt1) CellID = 1;
        else if(id == R.id.bt2) CellID = 2;
        else if(id == R.id.bt3) CellID = 3;
        else if(id == R.id.bt4) CellID = 4;
        else if(id == R.id.bt5) CellID = 5;
        else if(id == R.id.bt6) CellID = 6;
        else if(id == R.id.bt7) CellID = 7;
        else if(id == R.id.bt8) CellID = 8;
        else if(id == R.id.bt9) CellID = 9;

        if(Winer == -1 && startGame == 1){
            PlayGame(CellID, btSelected);
        }
    }

    void PlayGame(int CellID, Button btSelected){
        if(ActivePlayer == 1){
            btSelected.setText("X");
            btSelected.setBackgroundColor(Color.GREEN);
            btSelected.setTextColor(Color.RED);
            Player1.add(CellID);
            ActivePlayer = 2;
        } else {
            btSelected.setText("O");
            btSelected.setBackgroundColor(Color.BLUE);
            btSelected.setTextColor(Color.WHITE);
            Player2.add(CellID);
            ActivePlayer = 1;
        }

        btSelected.setEnabled(false);
        CheckWiner();

        if(Winer == 1){
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Player 1 thắng !");
        }
        else if(Winer == 2){
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Player 2 thắng !");
        }
        else if(Winer == 0){
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Hòa !");
        }
    }

    void PlayAgain(){
        Player1.clear();
        Player2.clear();
        Winer = -1;
        ActivePlayer = 1;

        Button[] buttons = {bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9};

        for(Button b : buttons){
            b.setText("");
            b.setEnabled(true);
            // Đặt lại màu nền xám giống giao diện mặc định ban đầu
            b.setBackgroundColor(Color.rgb(188, 185, 185));
        }

        txtShowresult.setVisibility(View.INVISIBLE);
    }

    void CheckWiner(){
        // Ma trận kiểm tra chiến thắng rất thông minh của bạn
        int[][] winPositions = {
                {1,2,3}, {4,5,6}, {7,8,9}, // 3 Hàng ngang
                {1,4,7}, {2,5,8}, {3,6,9}, // 3 Cột dọc
                {1,5,9}, {3,5,7}           // 2 Đường chéo
        };

        for(int[] pos : winPositions){
            if(Player1.contains(pos[0]) && Player1.contains(pos[1]) && Player1.contains(pos[2])){
                Winer = 1;
            }
            if(Player2.contains(pos[0]) && Player2.contains(pos[1]) && Player2.contains(pos[2])){
                Winer = 2;
            }
        }

        int sum = Player1.size() + Player2.size();
        // Hòa khi đánh đủ 9 ô và chưa ai thắng
        if(sum == 9 && Winer == -1){
            Winer = 0;
        }
    }
}