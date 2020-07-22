package com.example.user.gifticonmanagement;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.gifticonmanagement.db.DBManager;

import java.io.InputStream;

public class RegisterFormActivity extends AppCompatActivity implements View.OnClickListener {
    //레이아웃 관련 변수
    EditText gifticonName;
    DatePicker datePicker;
    Button galleryBtn, homeBtn, registerBtn;
    ImageView imageView;

    //Intent 관련 변수
    final int REQ_CODE_SELECT_IMAGE = 101;

    //SQLite 관련 변수
    DBManager       helper;
    SQLiteDatabase  db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        //DB 설정
        helper = new DBManager(this);
        try {
            //items.db에 "쓰기"가 가능하도록 DB 오픈
            db = helper.getWritableDatabase();
        }catch (SQLiteException e){
            db = helper.getReadableDatabase();
        }

        gifticonName = (EditText)findViewById(R.id.name);
        datePicker = (DatePicker)findViewById(R.id.datePicker);

        galleryBtn  = (Button)findViewById(R.id.select_image);
        homeBtn = (Button)findViewById(R.id.gotohome);
        registerBtn = (Button)findViewById(R.id.register_gift);

        imageView = (ImageView)findViewById(R.id.gifticon_image);

        galleryBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);

    }//end onCreate()

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select_image :
                /*Intent intent = new Intent();
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setType("image*//*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 101);*/

                //교수님
                //사용자가 갤러리에서 이미지를 선택
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);

                break;

            case R.id.gotohome :
                finish();
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;

            case R.id.register_gift:
                String name = gifticonName.getText().toString();
                break;

        }
    }//end onClick()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if(requestCode == 101 && resultCode == RESULT_OK){
            try{
                InputStream is = getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(is);
                is.close();
                imageView.setImageBitmap(bm);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(requestCode == 101 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show();
        }*/


    }//end onActivityResult()
}
