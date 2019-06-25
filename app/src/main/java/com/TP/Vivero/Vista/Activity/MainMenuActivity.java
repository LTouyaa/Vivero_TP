package com.TP.Vivero.Vista.Activity;

import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.TP.Vivero.Model.DatabaseHandler;
import com.TP.Vivero.Object.Etapa;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;
import com.TP.Vivero.Vista.Fragment.AgregarFragment;
import com.TP.Vivero.Vista.Fragment.MenuFragment;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    private MenuFragment menuFragment;
    private AgregarFragment agregarFragment;
    private FragmentManager fm;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        /**
         * Este Toolbar será común a todos los Fragment.
         * Como es personalizado (esta anulado en el Theme del Manifest.xml), entonces debo cargarle uno yo mismo.
         */
        toolbar =  findViewById(R.id.tb_main_menu);
        setSupportActionBar(toolbar);

        context =this;

        /**
         * Barra de navegacion que se encuentra en la inferior.
         */
        bottomNavigationView = findViewById(R.id.btm_nav_main_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        /**
         * Lo importante.
         * Acá instancio los dos Fragments, Menu y Agregar.
         * Esto permite que haya cierta 'continuidad' en los fragmentos y que aunque un fragment remplaze al otro en la app
         * el otro quede en realidad de fondo y no pierda su estado, o mejor dicho, no sea del todo destruido
         */

        menuFragment = new MenuFragment();
        agregarFragment = new AgregarFragment();

        fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.frm_main_menu, menuFragment).commit();
        /**
         * Entonces lo que hago es 'inflar' al administrador de Framents (fm) uno de los fragments, el que yo quiera.
         * Primero comienzo la trasicion (beginTransaction)
         * luego replazo el fragment que esta siendo mostrado por pantalla (replace)
         * El R.id.frm_main_menu es el FrameLayout donde se cargara toda la interfaz del fragment. (esta en R.layout.activity_main_menu).
         * El segundo parametro es el fragment que quiero cargar. En este caso menuFragment.
         * OPCIONAL1: Se puede poner un tercer parametro en replace, y es una String que sirve de etiqueta.
         * Esta etiqueta sirve para identificar los fragment que se van cargando en el fm. Es decir, porque cuando uno carga un fragment el que habia antes
         * queda 'guardado' es una pilla que se ira vaciando a medida que nosotros vamos dandole para atras a la flecha del telefono.
         * Esto irá vaciando dicha pilla hasta que llega un punto en que la pila esta vacia y uno sale de la app.
         * Esta etiqueta sirve para que cuando uno agrega un nuevo fragment a dicha pilla, si alguno da hacia atras se pueda volver a un fragment especifico
         * en vez de al fragment agregado anteriormente. Como se hace eso? Con la OPCION2.
         * OPCION2: Después del replace se puede poner '.addToBackStack(TAG)'. TAG es la etiqueta anteriormente mencionada. Esto sirve para indicar que cuando
         * este fragment que estoy 'inflando' sea sacado dandole atras el fragment que se va a cargar no será el que estaba antes sino el que cargué en
         * algun momento en el fm con dicho TAG.
         */
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.btm_nav_menu:
                fm.beginTransaction().replace(R.id.frm_main_menu, menuFragment).commit();
                break;
            case R.id.btm_nav_plantar:
                fm.beginTransaction().replace(R.id.frm_main_menu, agregarFragment).commit();
                break;
            default:
                return false;
        }
        return true;
    }
}
