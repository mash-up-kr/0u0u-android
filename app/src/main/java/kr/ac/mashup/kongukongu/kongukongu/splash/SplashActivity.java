package kr.ac.mashup.kongukongu.kongukongu.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import kr.ac.mashup.kongukongu.kongukongu.R;
import kr.ac.mashup.kongukongu.kongukongu.login.KakaoLoginActivity;


public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, KakaoLoginActivity.class);
                startActivity(intent);
            }
        }, 2000);

    }
}