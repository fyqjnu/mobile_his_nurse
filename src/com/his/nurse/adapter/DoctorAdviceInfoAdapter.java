package com.his.nurse.adapter;

import com.his.nurse.R;
import com.his.nurse.util.ILog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DoctorAdviceInfoAdapter extends BaseAdapter{
	private Context mContext;
	private LayoutInflater inflater;
	private int size;
	private int layoutRes;
	private String status;
	public DoctorAdviceInfoAdapter(Context context,int layout,String status){
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
		this.layoutRes = layout;
		this.status = status;
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
			convertView = inflater.inflate(layoutRes, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_yongfa = (TextView)convertView.findViewById(R.id.tv_yongfa);
			viewHolder.ll_yongfa = (LinearLayout)convertView.findViewById(R.id.ll_yongfa);
			viewHolder.tv_advice_name = (TextView)convertView.findViewById(R.id.tv_advice_name);
			viewHolder.tv_advice_guige = (TextView)convertView.findViewById(R.id.tv_advice_guige);
			viewHolder.tv_advice_yongliang = (TextView)convertView.findViewById(R.id.tv_advice_yongliang);
			viewHolder.tv_advice_give_way = (TextView)convertView.findViewById(R.id.tv_advice_give_way);
			if(R.layout.activity_doctor_advice_info_item == layoutRes){
				viewHolder.iv_doctor_advice_confirm = (ImageView)convertView.findViewById(R.id.iv_doctor_advice_confirm);
			}
			viewHolder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);
			convertView.setTag(viewHolder);
			}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tv_num.setText(status);
        if(position == 1){
        	viewHolder.tv_advice_name.setText("醒脑静注射液");
        	viewHolder.tv_advice_guige.setText("10ml*1支");
        	viewHolder.tv_advice_yongliang.setText("20ml");
        	viewHolder.tv_advice_give_way.setText("口服");
        	if(R.layout.activity_doctor_advice_info_item == layoutRes){
        		viewHolder.iv_doctor_advice_confirm.setVisibility(View.INVISIBLE);
        	}
        }else{
        	if(R.layout.activity_doctor_advice_info_item == layoutRes){
        		viewHolder.iv_doctor_advice_confirm.setVisibility(View.VISIBLE);
        	}
        }
        
        if(position%3 == 0){
        	viewHolder.tv_num.setVisibility(View.VISIBLE);
        	if(R.layout.activity_doctor_advice_info_item == layoutRes){
        		viewHolder.iv_doctor_advice_confirm.setVisibility(View.GONE);
        	}
        	viewHolder.tv_yongfa.setText("BID");
        }else{
        	viewHolder.tv_num.setVisibility(View.GONE);
        	if(R.layout.activity_doctor_advice_info_item == layoutRes){
        		viewHolder.iv_doctor_advice_confirm.setVisibility(View.VISIBLE);
        	}else if(R.layout.activity_temporary_doctor_advice_info_item == layoutRes){
        		viewHolder.tv_num.setVisibility(View.VISIBLE);
        	}
        	viewHolder.tv_yongfa.setText("QD");
        }
		return convertView;
	}
	
	static class ViewHolder{
		private TextView tv_advice_name;
		private TextView tv_advice_guige;
		private TextView tv_advice_yongliang;
		private TextView tv_advice_give_way;
		private TextView tv_yongfa;
		private LinearLayout ll_yongfa;
		private ImageView iv_doctor_advice_confirm;
		private TextView tv_num;
	}
	
}
