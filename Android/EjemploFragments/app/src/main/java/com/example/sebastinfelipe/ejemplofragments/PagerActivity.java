package com.example.sebastinfelipe.ejemplofragments;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import adapters.PagerAdapter;


public class PagerActivity extends ActionBarActivity {

    ViewPager pager;
    PagerAdapter padapter;
    List<Fragment> data;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        data=new ArrayList<>();
        pager=(ViewPager) findViewById(R.id.pager);
        android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        for(int i=0;i<6;i++)
        {
            ColorFragment fragment=new ColorFragment();
            fragment.init(i);
            data.add(fragment);
        }
        padapter=new PagerAdapter(getSupportFragmentManager(),data);
        pager.setAdapter(padapter);
    }
}
