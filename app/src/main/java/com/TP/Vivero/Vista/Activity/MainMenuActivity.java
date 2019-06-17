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

import com.TP.Vivero.R;
import com.TP.Vivero.Vista.Fragment.AgregarFragment;
import com.TP.Vivero.Vista.Fragment.MenuFragment;

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

        toolbar =  findViewById(R.id.tb_main_menu);
        setSupportActionBar(toolbar);

        context =this;

        bottomNavigationView = findViewById(R.id.btm_nav_main_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



        menuFragment = new MenuFragment();
        agregarFragment = new AgregarFragment();

        fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.frm_main_menu, new MenuFragment()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.btm_nav_menu:
                fm.beginTransaction().replace(R.id.frm_main_menu, new MenuFragment()).commit();
                break;
            case R.id.btm_nav_plantar:
                fm.beginTransaction().replace(R.id.frm_main_menu, new AgregarFragment()).commit();
                break;
            default:
                return false;
        }
        return true;
    }
}
