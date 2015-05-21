package com.example.sebastinfelipe.multiplespantallas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sebastinfelipe.multiplespantallas.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMaster extends Fragment {


    public FragmentMaster() {
        // Required empty public constructor
    }

    public void init()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.f_master, container, false);
    }


}
