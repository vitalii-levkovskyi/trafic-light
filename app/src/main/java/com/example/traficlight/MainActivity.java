package com.example.traficlight;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private boolean start_stop = true;

    private LinearLayout l1,l2,l3;
    private Button btn;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_switcher);
        l1 = findViewById(R.id.color1);
        l2 = findViewById(R.id.color2);
        l3 = findViewById(R.id.color3);
    }

    public void onClick(View view){

        if(start_stop){
            start_stop = false;
            btn.setText("Стоп");

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while(!start_stop){
                        counter++;

                        switch (counter){
                            case 1:
                                l1.setBackgroundResource(R.color.color1);
                                l2.setBackgroundResource(R.color.colorNone);
                                l3.setBackgroundResource(R.color.colorNone);
                                break;
                            case 2:
                                l1.setBackgroundResource(R.color.colorNone);
                                l2.setBackgroundResource(R.color.color2);
                                l3.setBackgroundResource(R.color.colorNone);
                                break;
                            case 3:
                                counter=0;
                                l1.setBackgroundResource(R.color.colorNone);
                                l2.setBackgroundResource(R.color.colorNone);
                                l3.setBackgroundResource(R.color.color3);
                                break;
                        }

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }



                }
            }).start();

        } else {
            btn.setText("Старт");
            start_stop = true;
            l1.setBackgroundResource(R.color.colorNone);
            l2.setBackgroundResource(R.color.colorNone);
            l3.setBackgroundResource(R.color.colorNone);
        }
    }
}