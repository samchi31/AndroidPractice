package com.example.myapp01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        EditText et1 = findViewById(R.id.et1);
        TextView tv3 = findViewById(R.id.tv3);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(et1.getText().toString());
                StringBuilder content = new StringBuilder();
                for(int i=1;i<10;i++) {
                    content.append(String.format("%d * %d = %d\n", num, i, num*i));
                }

                tv3.setText(content);
            }
        });

    }
}