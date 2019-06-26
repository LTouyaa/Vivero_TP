package com.TP.Vivero;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.Object.PlantaAnual;
import com.TP.Vivero.Object.PlantaPerenne;
import com.TP.Vivero.R;
import com.TP.Vivero.Vista.Activity.MainMenuActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usr;
    private EditText pass;

    private Button login;
    private Button ver;

    ViewModel model;

    DatabaseHandler db;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        db = new DatabaseHandler(this);

        usr = findViewById(R.id.edt_1);
        pass = findViewById(R.id.ed_2);
        login = findViewById(R.id.btm_1);
//        ver = findViewById(R.id.btm_view_model);

//       Planta planta = new PlantaAnual("Hola");
//       Planta planta2 = new PlantaPerenne("Adios");

//       ((PlantaAnual) planta).siguiente();

//       ((PlantaPerenne) planta2).siguiente();

//       Planta plantaAnual = new PlantaAnual("adada");

        login.setOnClickListener(v -> {

            if(usr.getText().toString().equals("Hola") && pass.getText().toString().equals("Mundo")){

                Intent intent = new Intent(context, MainMenuActivity.class);
                startActivity(intent);
            }else{

                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("ERROR");
                dialog.setMessage("Usuario ó Contraseña incorrectos");

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "sos un puto, pero ok", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(context, "sos un puto, cancelar", Toast.LENGTH_LONG).show();

                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


}
