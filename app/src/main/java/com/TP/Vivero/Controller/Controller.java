package com.TP.Vivero.Controller;

import android.content.Context;
import android.widget.Toast;

<<<<<<< HEAD
import com.TP.Vivero.Model.TimeModel;

=======
>>>>>>> RamaLucas
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    @Override
    public void update(Observable o, Object arg) {
<<<<<<< HEAD



        if(o.getClass().equals(TimeModel.class)) Toast.makeText((Context) arg, "TimeModel", Toast.LENGTH_SHORT).show();
=======
        Toast.makeText((Context) arg, "TimeController", Toast.LENGTH_SHORT).show();
>>>>>>> RamaLucas
    }
}
