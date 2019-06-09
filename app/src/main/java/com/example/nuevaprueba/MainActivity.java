package com.example.nuevaprueba;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nuevaprueba.model.ViewModel;
import com.example.nuevaprueba.ui.activity.AgregarPlantaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombre;
    private EditText apellido;

    private Button login;
    private Button ver;

    ViewModel model;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        nombre = findViewById(R.id.edt_1);
        apellido = findViewById(R.id.ed_2);
        login = findViewById(R.id.btm_1);
        ver = findViewById(R.id.btm_view_model);


    }

    @Override
    public void onClick(View v) {

    }
}
