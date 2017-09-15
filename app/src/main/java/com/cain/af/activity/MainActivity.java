package com.cain.af.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cain.af.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }


    private Intent intent;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                intent = new Intent();
                intent.setClass(MainActivity.this,ActivityOne.class);
                startActivity(intent);
                Log.e("111","button1");
                break;
            case R.id.button2:
                intent = new Intent();
                intent.setClass(MainActivity.this,ActivityTwo.class);
                startActivity(intent);
                Log.e("111","button1");
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
        }
    }

}
