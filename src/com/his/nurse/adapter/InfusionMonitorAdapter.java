package com.his.nurse.adapter;

import java.util.List;

import com.his.nurse.R;
import com.his.nurse.entity.Patient;
import com.his.nurse.util.DensityUtil;
import com.his.nurse.widget.BottleView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 
 * @author gordon
 * 输液监控数据
 */
public class InfusionMonitorAdapter extends BaseAdapter {
	
	private Context ctx;
	private List<Patient> patients;

	public InfusionMonitorAdapter(Context ctx) {
		this.ctx = ctx;
	}
	
	public InfusionMonitorAdapter(Context ctx, List<Patient> list) {
		this.ctx = ctx;
		this.patients = list;
	} 

	@Override
	public int getCount() {
		return patients==null?0:patients.size();
	}

	@Override
	public Object getItem(int position) {
		return patients.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ItemView  iv = (ItemView) view;
		if (iv == null) {
			iv = new ItemView(ctx);
		}
		
		Patient info = (Patient) getItem(position);
		iv.bv.setRemainProgress(info.infusionProgress);
		iv.tvName.setText(info.bedNum + " " + info.name);
		return iv;
	}
	
	class ItemView extends LinearLayout {

		private TextView tvName;
		private BottleView bv;

		public ItemView(Context context) {
			super(context);
			setOrientation(1);
			int p = context.getResources().getDimensionPixelSize(R.dimen.item_vertical_space) * 2;
			setPadding(0, p, 0, 0);
//			setBackgroundResource(R.color.item_background);
			setGravity(Gravity.CENTER_HORIZONTAL);
			bv = new BottleView(getContext());
			addView(bv, -1, -2);
			tvName = new TextView(getContext(),null,  R.style.app_medium_textStyle_black);
//			tvName.setTextSize(15);
//			tvName.setTextColor(Color.BLACK);
			addView(tvName, -2, -2);
			ImageView line = new ImageView(getContext());
			line.setBackgroundColor(0xffb1b1b1);
			LinearLayout.LayoutParams lineLp = new LinearLayout.LayoutParams(-1, 1); 
			lineLp.topMargin = p;
			addView(line, lineLp);
			
		}
		
		
		
	}

}
