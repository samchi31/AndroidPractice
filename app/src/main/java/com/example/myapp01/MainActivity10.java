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
        // alert??? title??? Messege ??????
        myAlertBuilder.setTitle("???????????????");
        myAlertBuilder.setMessage("???????????????");
        // ?????? ?????? (Ok ????????? Cancle ?????? )
        myAlertBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                // OK ????????? ????????? ??????
                Toast.makeText(getApplicationContext(),"Pressed OK",
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancle ????????? ????????? ??????
                Toast.makeText(getApplicationContext(),"Pressed Cancle",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Alert??? ??????????????? ???????????? ?????????(show??? ???????????? Alert??? ?????????)
        myAlertBuilder.show();

    }

}