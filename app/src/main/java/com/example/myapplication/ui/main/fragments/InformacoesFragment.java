package com.example.myapplication.ui.main.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.CovidAdapter;
import com.example.myapplication.connection.ConnectionManager;
import com.example.myapplication.model.CovidBrasil;
import com.example.myapplication.util.Util;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformacoesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformacoesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView listView;
    ArrayList listaCovid;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InformacoesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformacoesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformacoesFragment newInstance(String param1, String param2) {
        InformacoesFragment fragment = new InformacoesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacoes, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listaCovid = new ArrayList <CovidBrasil>();
        ConnectionManager con = new ConnectionManager(listaCovid);
        con.recuperarValoresEstados();
        listView = (ListView) getView().findViewById(R.id.listaEstados);
        CovidAdapter covidAdapter = new CovidAdapter(getActivity(), listaCovid);
        listView.setAdapter(covidAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

}