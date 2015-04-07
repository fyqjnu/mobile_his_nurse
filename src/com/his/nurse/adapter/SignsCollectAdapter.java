package com.his.nurse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.his.nurse.R;

public class SignsCollectAdapter extends BaseAdapter{
	private Context mContext;
	private LayoutInflater inflater;
	private int size;
	public SignsCollectAdapter(Context context){
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return size;
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
			convertView = inflater.inflate(R.layout.activity_signscollect_item, null);
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
