package com.TP.Vivero.Controller;

import android.content.Context;
import android.widget.Toast;

import com.TP.Vivero.Model.TimeModel;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @Override
    public void update(Observable o, Object arg) {



        if(o.getClass().equals(TimeModel.class)) Toast.makeText((Context) arg, "TimeModel", Toast.LENGTH_SHORT).show();
    }
}
