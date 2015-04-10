package com.his.nurse.adapter;

import com.his.nurse.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckDrugDetailAdapter extends BaseAdapter {

    
    private Context ctx;

    public CheckDrugDetailAdapter(Context ctx) {
        this.ctx = ctx;
    }
    
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_check_drug_detail, null);
            vh = new ViewHolder();
            vh.tvIndex = (TextView) view.findViewById(R.id.item_check_drug_detail_tv_index);
            vh.cbState = (CheckBox) view.findViewById(R.id.item_check_drug_detail_cb_state);
            vh.tvDrugName = (TextView) view.findViewById(R.id.item_check_drug_detail_tv_drug_name);
            view.setTag(vh);
        }else {
            vh = (ViewHolder) view.getTag();
        }
        vh.tvIndex.setText(String.format("%d.", position+1));
        if (position<4) {
            vh.cbState.setChecked(true);
        } else {
            vh.cbState.setChecked(false);
        }
        vh.cbState.setEnabled(false);
        return view;
    }
    
    
    class ViewHolder {
        TextView tvIndex;
        TextView tvDrugName;
        CheckBox cbState;
    }
    

}
