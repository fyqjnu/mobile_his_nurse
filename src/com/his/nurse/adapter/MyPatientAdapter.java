package com.his.nurse.adapter;

import com.his.nurse.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyPatientAdapter extends BaseAdapter{
	private Context mContext;
	private LayoutInflater inflater;
	public MyPatientAdapter(Context context){
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int selectId = position;
		ViewHolder viewHolder = null;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.my_patient_gridview_item, null);
			viewHolder = new ViewHolder();
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	
	static class ViewHolder{
		
	}

}
