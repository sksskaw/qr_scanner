package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        new IntentIntegrator(this).initiateScan();
        // Scaner 객체 생성 어플 실행 시 바로 스케너가 켜지게 된다.
        // MainActivity에서 카메라스케너 activity 호출
        // MainActivity내부에 카메라스케너 생성
    }

    @Override // MainActivity와 카메라스케너가 통신하기위한 메소드, 스켄이 이루어지면 메소드 실행
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) { // 스켄 정보가 없으면, 데이터가 없으면 Cancelled 출력
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                // todo
            } else { // 스켄 성공시 QR데이터 출력
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                // todo
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}