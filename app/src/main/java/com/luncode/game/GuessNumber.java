package com.luncode.game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GuessNumber extends AppCompatActivity {
    private int happy=R.drawable.happy;
    private int angry=R.drawable.angry;
    int randnumber = (int)(Math.random()*100);
    EditText editText;
    Button button;
    TextView reslut;
    ImageView resultImage;
    int temp;
    boolean continuegame=true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("猜数字");
        setContentView(R.layout.activity_number);
        resultImage =(ImageView) findViewById(R.id.resultImage);
        button=(Button)findViewById(R.id.button_anser);
        editText=(EditText)findViewById(R.id.edit_1);
        reslut = (TextView)findViewById(R.id.text_reslut);
        //System.out.println(randnumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.length() < 1) {
                    Toast.makeText(getApplication(),"不能为空",Toast.LENGTH_SHORT).show();
                } else {
                    temp = Integer.parseInt(editText.getText().toString());
                    if (temp <= 100 && temp >= 0) {
                        if (temp > randnumber) {
                            editText.setText("");
                            editText.setHint("0");
                            reslut.setText("结果显示：输入的数字大了");
                            resultImage.setImageResource(angry);
                        } else if (temp < randnumber) {
                            editText.setText("");
                            editText.setHint("0");
                            reslut.setText("结果显示：输入的数字小了");
                            resultImage.setImageResource(angry);
                        } else if (temp == randnumber) {
                            editText.setText("");
                            reslut.setText("结果显示：输入的数字正确\n答案：" + randnumber);
                            resultImage.setImageResource(happy);
                            randnumber = (int) (Math.random() * 100);
                            //System.out.println(randnumber);
                            continuegame = false;
                        }
                    } else {
                        Toast.makeText(getApplication(), "输入的数字不符合", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
