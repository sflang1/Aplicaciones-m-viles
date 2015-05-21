package com.example.sebastinfelipe.ejemplofragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    public static final int BLUE=0;
    public static final int YELLOW=1;
    public static final int RED=2;
    public static final int GREEN=3;
    public static final int VIOLET=4;
    public static final int ORANGE=5;
    public int color;

    public ColorFragment() {
        // Required empty public constructor
    }
    public void init(int color)
    {
        this.color=color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_color, container, false);
        int colors[]=getResources().getIntArray(R.array.colores);
        String colorName[]=getResources().getStringArray(R.array.colorsName);
        Log.i("app","Posición elegida: "+color);
        for(int i=0;i<colors.length;i++)
        {
            Log.i("app","Color en la pos: "+i+": "+colors[i] );
        }
        for(int i=0;i<colorName.length;i++)
        {
            Log.i("app","Nombre de color en la pos: "+i+": "+colorName[i] );
        }
        TextView text=(TextView) v.findViewById(R.id.textoaCambiar);
        text.setText("You've selected the color: "+colorName[color]);
        text.setBackgroundColor(colors[color]);

        return v;
    }


}
