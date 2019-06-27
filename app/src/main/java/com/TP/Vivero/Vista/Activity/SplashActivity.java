package com.TP.Vivero.Vista.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.TP.Vivero.MainActivity;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Model.Factory;
import com.TP.Vivero.R;


public class SplashActivity extends Activity {

    Handler handler;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        db = new DatabaseHandler(this);
        //deleteDatabase(db.getDatabaseName());

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Factory factory = new Factory(SplashActivity.this);
                factory.init();

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 300);

    }
}
