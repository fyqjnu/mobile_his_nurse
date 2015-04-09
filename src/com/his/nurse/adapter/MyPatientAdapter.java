package com.his.nurse.adapter;

import com.his.nurse.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
			viewHolder.iv_nursing_level_1 = (ImageView)convertView.findViewById(R.id.iv_nursing_level_1);
			viewHolder.iv_enter_doctor_advice = (ImageView)convertView.findViewById(R.id.iv_enter_doctor_advice);
			viewHolder.tv_bedno = (TextView)convertView.findViewById(R.id.tv_bedno);
			viewHolder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
			viewHolder.tv_sex = (TextView)convertView.findViewById(R.id.tv_sex);
			viewHolder.tv_age = (TextView)convertView.findViewById(R.id.tv_age);
			viewHolder.tv_check_result = (TextView)convertView.findViewById(R.id.tv_check_result);
			viewHolder.tv_hos_no = (TextView)convertView.findViewById(R.id.tv_hos_no);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		if(position%4 == 0){
			viewHolder.iv_nursing_level_1.setVisibility(View.VISIBLE);
			viewHolder.iv_enter_doctor_advice.setVisibility(View.VISIBLE);
			viewHolder.tv_name.setVisibility(View.VISIBLE);
			viewHolder.tv_sex.setVisibility(View.VISIBLE);
			viewHolder.tv_age.setVisibility(View.VISIBLE);
			viewHolder.tv_check_result.setVisibility(View.VISIBLE);
			viewHolder.tv_hos_no.setVisibility(View.VISIBLE);
			viewHolder.tv_bedno.setVisibility(View.VISIBLE);
			
			viewHolder.iv_nursing_level_1.setBackgroundResource(R.drawable.nurse_nursing_level_1);
			viewHolder.tv_bedno.setText((1001+position)+"");
			viewHolder.tv_name.setText("刘建国");
			viewHolder.tv_sex.setText("男");
			viewHolder.tv_age.setText("56");
			viewHolder.tv_hos_no.setText("100102045");
		}else if(position%4 == 1){
			viewHolder.iv_nursing_level_1.setVisibility(View.VISIBLE);
			viewHolder.iv_enter_doctor_advice.setVisibility(View.VISIBLE);
			viewHolder.tv_name.setVisibility(View.VISIBLE);
			viewHolder.tv_sex.setVisibility(View.VISIBLE);
			viewHolder.tv_age.setVisibility(View.VISIBLE);
			viewHolder.tv_check_result.setVisibility(View.VISIBLE);
			viewHolder.tv_hos_no.setVisibility(View.VISIBLE);
			viewHolder.tv_bedno.setVisibility(View.VISIBLE);
			
			viewHolder.iv_nursing_level_1.setBackgroundResource(R.drawable.nurse_nursing_level_2);
			viewHolder.tv_bedno.setText((1001+position)+"");
			viewHolder.tv_name.setText("吴亚莉");
			viewHolder.tv_sex.setText("女");
			viewHolder.tv_age.setText("28");
			viewHolder.tv_hos_no.setText("100102038");
		}else if(position%4 == 2){
			viewHolder.iv_nursing_level_1.setVisibility(View.INVISIBLE);
			viewHolder.iv_enter_doctor_advice.setVisibility(View.INVISIBLE);
			viewHolder.tv_name.setVisibility(View.INVISIBLE);
			viewHolder.tv_sex.setVisibility(View.VISIBLE);
			viewHolder.tv_age.setVisibility(View.VISIBLE);
			viewHolder.tv_check_result.setVisibility(View.INVISIBLE);
			viewHolder.tv_hos_no.setVisibility(View.INVISIBLE);
			viewHolder.tv_bedno.setVisibility(View.INVISIBLE);
			
			viewHolder.iv_nursing_level_1.setBackgroundResource(R.drawable.nurse_nursing_level_3);
			viewHolder.tv_bedno.setText((1001+position)+"");
			viewHolder.tv_name.setText("刘建国");
			viewHolder.tv_sex.setText((1001+position)+"");
			viewHolder.tv_age.setText(" 空闲");
			viewHolder.tv_hos_no.setText("100102045");
		}else if(position%4 == 3){
			viewHolder.iv_nursing_level_1.setVisibility(View.VISIBLE);
			viewHolder.iv_enter_doctor_advice.setVisibility(View.VISIBLE);
			viewHolder.tv_name.setVisibility(View.VISIBLE);
			viewHolder.tv_sex.setVisibility(View.VISIBLE);
			viewHolder.tv_age.setVisibility(View.VISIBLE);
			viewHolder.tv_check_result.setVisibility(View.VISIBLE);
			viewHolder.tv_hos_no.setVisibility(View.VISIBLE);
			viewHolder.tv_bedno.setVisibility(View.VISIBLE);
			
			viewHolder.iv_nursing_level_1.setBackgroundResource(R.drawable.nurse_nursing_level_4);
			viewHolder.tv_bedno.setText((1001+position)+"");
			viewHolder.tv_name.setText("吴亚莉");
			viewHolder.tv_sex.setText("女");
			viewHolder.tv_age.setText("28");
			viewHolder.tv_hos_no.setText("100102038");
		}
		return convertView;
	}
	
	static class ViewHolder{
		private ImageView iv_nursing_level_1;
		private ImageView iv_enter_doctor_advice;
		private TextView tv_bedno;
		private TextView tv_name;
		private TextView tv_sex;
		private TextView tv_age;
		private TextView tv_check_result;
		private TextView tv_hos_no;
	}

}
