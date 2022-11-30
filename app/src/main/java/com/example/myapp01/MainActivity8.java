package com.example.myapp01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        EditText et_f = findViewById(R.id.et_f);
        EditText et_l = findViewById(R.id.et_l);
        TextView tv_disp = findViewById(R.id.tv_disp);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int start = Integer.parseInt(et_f.getText().toString());
                int end = Integer.parseInt(et_l.getText().toString());

                StringBuilder content = new StringBuilder();

                for(int i= start; i<=end;i++){
                    for(int j = 1; j <= i; j++){
                        content.append("*");
                    }
                    content.append("\n");

                }

                tv_disp.setText(content);
            }
        });

    }
}