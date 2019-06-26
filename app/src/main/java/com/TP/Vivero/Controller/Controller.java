package com.TP.Vivero.Controller;

import android.content.Context;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Toast.makeText((Context) arg, "TimeController", Toast.LENGTH_SHORT).show();
    }
}
