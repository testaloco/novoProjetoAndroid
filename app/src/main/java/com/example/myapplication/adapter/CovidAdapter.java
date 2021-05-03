package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.CovidBrasil;

import java.util.List;

public class CovidAdapter extends ArrayAdapter<CovidBrasil> {
    private Context context;
    private List<CovidBrasil> covidBrasilLista = null;

    public CovidAdapter(Context context,  List<CovidBrasil> covidBrasilLista) {
        super(context, 0, covidBrasilLista);
        this.covidBrasilLista = covidBrasilLista;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        CovidBrasil covidBrasil = covidBrasilLista.get(position);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.covid_adapter, null);

        TextView ufNome = (TextView) view.findViewById(R.id.textViewNomeEstado);
        ufNome.setText(covidBrasil.getEstado());
        return view;
    }
}
