package com.example.sebastinfelipe.apppostres.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sebastinfelipe.apppostres.R;
import com.example.sebastinfelipe.apppostres.models.Postre;

import java.util.List;


/**
 * Created by SebastiánFelipe on 18/04/2015.
 */
public class PostreAdapter extends BaseAdapter
{
    Context context;
    public List<Postre> lista;
    public PostreAdapter(Context c,List<Postre> p)
    {
        context=c;
        lista=p;
    }
    @Override
    public int getCount()
    {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v;
        if(convertView==null)
        {
            v=View.inflate(context,R.layout.list_template,null);  //En caso de excepciones. De todos modos,
                                                                  //Se llena el View en el paso siguiente
        }
        else
        {
            v=convertView;
        }
        Postre p= (Postre) getItem(position);
        TextView txt_Nombre= (TextView) v.findViewById(R.id.txt_nombre);  //Obtener los View del Layout
        TextView txt_Descripcion= (TextView) v.findViewById(R.id.Descripcion);
        TextView txt_Duracion= (TextView) v.findViewById(R.id.duracion);
        TextView txt_Precio= (TextView) v.findViewById(R.id.precio);
        txt_Nombre.setText(p.getNombre());  //Llenarlos con los valores que se obtienen de la lista
        txt_Duracion.setText(p.getDuracion());
        txt_Descripcion.setText(p.getDescripcion());
        txt_Precio.setText(p.getPrecio());
        return v;
    }
}
