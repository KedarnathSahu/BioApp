package com.sahu97gmail.kedarnath.bioapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class UniversalAdapter extends BaseAdapter {
    Context ctx;
    int[][] m_int;
    int[][] f_int;
    String hint;
    Integer position;//row
    LayoutInflater layoutInflater;
    public UniversalAdapter(Context ctx, int[][] m_int, int[][] f_int,Integer position,String hint) {
        this.ctx=ctx;
        this.m_int=m_int;
        this.f_int=f_int;
        this.hint=hint;
        this.position=position;
        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(hint.equalsIgnoreCase("MenActivity")){
            return m_int[position].length;
        }else{
            return f_int[position].length;
        }
    }

    @Override
    public Object getItem(int i) {
        if(hint.equalsIgnoreCase("MenActivity")){
            return m_int[position][i];
        }else{
            return f_int[position][i];
        }
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            if(hint.equalsIgnoreCase("MenActivity")){
                view=layoutInflater.inflate(R.layout.custom_grid,null);
                ImageView iv1=(ImageView)view.findViewById(R.id.imageView5);
                iv1.setImageResource(m_int[position][i]);
            }else{
                view=layoutInflater.inflate(R.layout.custom_grid,null);
                ImageView iv1=(ImageView)view.findViewById(R.id.imageView5);
                iv1.setImageResource(f_int[position][i]);
            }
        }
        return view;
    }
}