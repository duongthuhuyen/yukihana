package com.example.beanikaa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_second extends AppCompatActivity {

    private Button congBtn, truBtn, cartBtn;
    private TextView amountTv, billTv;
    private ImageView heartImg;
    public int soLuong, tongTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_second);

        congBtn = findViewById(R.id.congBtn);
        truBtn = findViewById(R.id.truBtn);
        cartBtn = findViewById(R.id.cartBtn);
        amountTv = findViewById(R.id.amountTv);
        billTv = findViewById(R.id.billTv);
        heartImg = findViewById(R.id.heartImg);
        soLuong = Integer.parseInt(amountTv.getText().toString());


        heartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String backgroundImageName = String.valueOf(heartImg.getTag());
                if (backgroundImageName == "heart") {
                    heartImg.setImageResource(R.drawable.hearted);
                    heartImg.setTag("hearted");
                }
                else {
                    heartImg.setImageResource(R.drawable.heart);
                    heartImg.setTag("heart");
                }
            }
        });

        congBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soLuong++;
                amountTv.setText(String.valueOf(soLuong));
                tongTien = 55 * soLuong;
                billTv.setText(String.valueOf(tongTien) + ".000đ");
            }
        });

        truBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soLuong > 1) {
                    soLuong--;
                    amountTv.setText(String.valueOf(soLuong));
                    tongTien = 55 * soLuong;
                    billTv.setText(String.valueOf(tongTien) + ".000đ");
                }
            }
        });

    }
}