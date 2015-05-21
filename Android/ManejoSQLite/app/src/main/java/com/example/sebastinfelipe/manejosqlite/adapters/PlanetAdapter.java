package com.example.sebastinfelipe.manejosqlite.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sebastinfelipe.manejosqlite.R;
import com.example.sebastinfelipe.manejosqlite.models.Planeta;

import java.util.List;

/**
 * Created by SebastiánFelipe on 08/05/2015.
 */
public class PlanetAdapter extends BaseAdapter
{
    private List<Planeta> data;
    private Context context;

    public List<Planeta> getData() {
        return data;
    }

    public void setData(List<Planeta> data) {
        this.data = data;
    }

    public PlanetAdapter(Context c,List<Planeta> p)
    {
        context=c;
        data=p;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getIdPlaneta();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v;
        if(convertView==null)
        {
            v=View.inflate(context, R.layout.planet_template,null);
        }
        else
        {
            v=convertView;
        }
        Planeta p=new Planeta();
        p=data.get(position);
        TextView nomPlaneta= (TextView) v.findViewById(R.id.nomPlaneta);
        TextView gravPlaneta= (TextView) v.findViewById(R.id.gravPlaneta);
        nomPlaneta.setText(p.getNombre());
        gravPlaneta.setText("Gravedad del planeta: "+p.getGravedad());
        return v;
    }
}
