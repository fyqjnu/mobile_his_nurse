package com.his.nurse.adapter;

import com.his.nurse.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author gordon
 * 核药
 */
public class CheckDrugAdapter extends BaseAdapter {
    
    private Context ctx;

    public CheckDrugAdapter(Context ctx) {
        this.ctx = ctx;
    }
    
    
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_check_drug, null);
        }
        return view;
    }
    
    class ViewHolder {
        TextView tvDrugName;
    }

}
