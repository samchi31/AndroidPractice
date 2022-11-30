package com.example.myapp01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        EditText et_mine = findViewById(R.id.et_mine);
        EditText et_com = findViewById(R.id.et_com);
        EditText et_result = findViewById(R.id.et_result);

        String[] coms = new String[]{"가위", "바위", "보"};
        
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String me = et_mine.getText().toString();
                String com = coms[(int)(Math.random()*3)];

                et_com.setText(com);
                if(com.equals(me)){
                    et_result.setText("비김");
                } else if((com.equals("가위")&&me.equals("바위"))||
                        (com.equals("바위")&&me.equals("보"))||
                        (com.equals("보")&&me.equals("가위"))){
                    et_result.setText("me 이김");
                } else {
                    et_result.setText("com 이김");
                }
            }
        });

    }
}