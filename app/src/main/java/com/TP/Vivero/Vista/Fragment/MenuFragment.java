package com.TP.Vivero.Vista.Fragment;

import android.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.TP.Vivero.Model.Model;
import com.TP.Vivero.Object.Planta;
import com.TP.Vivero.R;

public class MenuFragment extends Fragment {

    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.buton);

        Model model = ViewModelProviders.of((FragmentActivity) getActivity()).get(Model.class);
//
        Planta planta = new Planta();
        planta.setNombre("Pepino");

        button.setOnClickListener(v -> model.planta(planta, getActivity()));
    }
}
