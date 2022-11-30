package com.example.myapp01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        String com = makeRandomNum();

        EditText et1 = findViewById(R.id.et1);
        TextView tv_result = findViewById(R.id.tv_result);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNum = et1.getText().toString();
                char[] numChars = strNum.toCharArray();
                int ballCnt=0;
                int strikeCnt=0;
                for (int i=0 ; i<numChars.length;i++) {
                    if(com.indexOf(numChars[i]) != -1){
                        if(com.indexOf(numChars[i]) == i){
                            strikeCnt++;
                            continue;
                        }
                        ballCnt++;
                    }
                }
                String old = tv_result.getText().toString();
                String result = "";
                if(strikeCnt == 3){
                    f_alert();
                    result=" com:"+com;
                } else if(ballCnt == 0 && strikeCnt == 0){
                    result = "3Out\n";
                } else {
                    result = ballCnt+"Ball," + strikeCnt +"Strike\n";
                }
                tv_result.setText(old+strNum+":::::"+result);

                et1.setText("");
            }
        });
    }

    String makeRandomNum(){
        Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
        Collections.shuffle(Arrays.asList(arr));
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<3;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public void f_alert(/*View view*/) {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(MainActivity10.this);
        // alert의 title과 Messege 세팅
        myAlertBuilder.setTitle("축하합니다");
        myAlertBuilder.setMessage("정답입니다");
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                // OK 버튼을 눌렸을 경우
                Toast.makeText(getApplicationContext(),"Pressed OK",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancle 버튼을 눌렸을 경우
                Toast.makeText(getApplicationContext(),"Pressed Cancle",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
        myAlertBuilder.show();

    }

}