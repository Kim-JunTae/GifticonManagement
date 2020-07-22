package com.example.user.gifticonmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //레이아웃 관련 변수
    Button registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerBtn = (Button)findViewById(R.id.img_register_gift);
        registerBtn.setOnClickListener(this);

    }//end onCreate()

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_register_gift :
                //이유를 찾아보자
                finish();

                Intent registerIntent = new Intent(this, RegisterFormActivity.class);
                startActivity(registerIntent);
                break;
        }

    }//end onClick()
}
