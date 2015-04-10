package com.his.nurse.adapter;

import com.his.nurse.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NursingRecordAdapter extends BaseAdapter {
    
    private Context ctx;

    public NursingRecordAdapter(Context ctx) {
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
        if (view==null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_nursing_record, null);
            ViewHolder vh = new ViewHolder();
            view.setTag(vh);
            vh.tvIndex = (TextView) view.findViewById(R.id.item_nursing_record_index);
            vh.tvPatientName = (TextView) view.findViewById(R.id.item_nursing_record_patient_name);
            vh.tvRecordName = (TextView) view.findViewById(R.id.item_nursing_record_record_name);
            vh.tvRecordTime = (TextView) view.findViewById(R.id.item_nursing_record_time);
            vh.tvNurseName = (TextView) view.findViewById(R.id.item_nursing_record_nursing_name);
        }
        ViewHolder vh = (ViewHolder) view.getTag();
        vh.tvIndex.setText(String.format("%d.", 1+position));
        return view;
    }
    
    class ViewHolder {
        TextView tvIndex;
        TextView tvPatientName;
        TextView tvRecordName;
        TextView tvRecordTime;
        TextView tvNurseName;
    }

}
