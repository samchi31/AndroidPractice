package com.example.myapp01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    //홀 짝
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        EditText et_mine = (EditText) findViewById(R.id.et_mine);
        EditText et_com = (EditText) findViewById(R.id.et_com);
        EditText et_result = (EditText) findViewById(R.id.et_result);

        String[] coms = new String[]{"홀", "짝"};

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String me = et_mine.getText().toString();
                String com = coms[(int)(Math.random()*2)];
                et_com.setText(com);
                if(com.equals(me)){
                    et_result.setText("이김");
                } else {
                    et_result.setText("짐");
                }
            }
        });

    }


}