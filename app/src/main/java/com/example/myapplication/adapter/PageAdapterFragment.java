package com.example.myapplication.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.ui.main.fragments.FuncionalidadesFragment;
import com.example.myapplication.ui.main.fragments.InformacoesFragment;
import com.example.myapplication.ui.main.fragments.PesquisaFragment;

public class PageAdapterFragment extends FragmentPagerAdapter {
    private final String[] PAGE_TITLES = new String[] {
            "Pesquisa",
            "Informacoes",
            "Funcionalidades"
    };

    // The fragments that are used as the individual pages
    private final Fragment[] PAGES = new Fragment[] {
            new PesquisaFragment(),
            new InformacoesFragment(),
            new FuncionalidadesFragment()
    };
    public PageAdapterFragment(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return PAGES[position];
    }

    @Override
    public int getCount() {
        return PAGES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }

}
