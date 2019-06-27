package com.TP.Vivero.Model;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.TP.Vivero.Controller.Controller;
import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Planta;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimeModel extends Observable{

    private Handler handler;
    private Runnable runnable;

    private Controller controller;

    private Context context;

    public TimeModel(Controller controller){

        this.controller = controller;

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                notifyObservers();

                handler.postDelayed(runnable, 8000);
            }
        };

        handler.post(runnable);

    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
        controller.update(this, null);
    }
}
