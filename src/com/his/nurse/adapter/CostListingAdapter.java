package com.his.nurse.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.his.nurse.R;
import com.his.nurse.activity.CostListingActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CostListingAdapter extends BaseAdapter{
	private Context mContext;
	private LayoutInflater inflater;
	private int total = 0;
	private TextView tv_total_money;
	public CostListingAdapter(Context context,TextView tv_total_money){
		this.mContext = context;
		this.inflater = LayoutInflater.from(context);
		this.tv_total_money = tv_total_money;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 8;
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
		final int SelectId = position;
		ViewHolder viewHolder = null;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.activity_today_cost_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_pay_money = (TextView)convertView.findViewById(R.id.tv_pay_money);
			viewHolder.tv_pay_time = (TextView)convertView.findViewById(R.id.tv_pay_time);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		Random random = new Random();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日");
		if(position<4){
			viewHolder.tv_pay_time.setText(dateformat.format(new Date())+" "+(random.nextInt(13)+10)+":"+(random.nextInt(49)+10));
		}else{
			viewHolder.tv_pay_time.setText(dateformat.format(new Date())+" "+"0"+(random.nextInt(8)+1)+":"+(random.nextInt(49)+10));
		}
		int pay_money = ((random.nextInt(15)+1)*1000);
		total = total+pay_money;
		tv_total_money.setText(total+"元");
		viewHolder.tv_pay_money.setText(pay_money+"元");
		
		return convertView;
	}

	static class ViewHolder{
		private TextView tv_pay_time;
		private TextView tv_pay_money;
	}
}
