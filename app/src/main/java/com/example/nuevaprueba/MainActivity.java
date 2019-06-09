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

        model = ViewModelProviders.of(this).get(ViewModel.class);

        model.getNombPlantas().observe( this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(context, "Main:" , Toast.LENGTH_LONG).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AgregarPlantaActivity.class);
                startActivity(intent);

                Toast.makeText(context, "Hola Mundo", Toast.LENGTH_SHORT).show();
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// Podrás mostrar el icono de la notificación, en este caso una alerta
                Notification notification = new Notification(android.R.drawable.stat_sys_warning,
                        "Notificación", System.currentTimeMillis());

                CharSequence titulo = "Alerta";

// Clase de Notification
//        Intent notificationIntent = new Intent(this, NotificationActivity.class);
//        PendingIntent contIntent = PendingIntent.getActivity(this, , notificationIntent, );
//        notification.setLatestEventInfo(this, "Aviso de notificación", "Esto es un ejemplo de notificación", contIntent);
//
//        notification.flags |= Notification.FLAG_AUTO_CANCEL;

//importante
                int not_id = 1;
                notificationManager.notify(not_id, notification);



            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
