package com.example.sebastinfelipe.ejemplofragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListColorFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView lista;
    ListColorI colorI;
    public interface ListColorI
    {
        public void changeColor(int color);  //Se deja un método abstracto para que lo implemente de manera distinta cada activity
    }

    public void init(ListColorI colorI)
    {
        this.colorI=colorI;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        colorI.changeColor(position);
    }
    public ListColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_list_color,container,false);
        lista=(ListView) v.findViewById(R.id.listabarralateral);
        //No se pone lo de si es nulo porque esta interfaz se instancia una única vez, a diferencia de los adapters
        lista.setOnItemClickListener(this);
        return v;
    }



}
