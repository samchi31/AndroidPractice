package com.example.myapp01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        List<TextView> tvs = new ArrayList<TextView>();
        for(int i=0;i<tvs.size();i++){
            tvs.add((TextView) findViewById(R.id.tv+i));
        }
//        tvs.add((TextView) findViewById(R.id.tv1));
//        tvs.add((TextView) findViewById(R.id.tv2));
//        tvs.add((TextView) findViewById(R.id.tv3));
//        tvs.add((TextView) findViewById(R.id.tv4));
//        tvs.add((TextView) findViewById(R.id.tv5));
//        tvs.add((TextView) findViewById(R.id.tv6));

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer[] arr = new Integer[45];
                for(int i=0;i<arr.length;i++){
                    arr[i]= i+1;
                }

                List<Integer> arrlist = Arrays.asList(arr);
                Collections.shuffle(arrlist);

                for(int i=0;i<tvs.size();i++){
                    tvs.get(i).setText(Integer.toString(arrlist.get(i)));
                }
            }
        });

    }


}