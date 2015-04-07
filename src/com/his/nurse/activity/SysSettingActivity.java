package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SysSettingActivity extends BaseFragment{
	private MainActivity act;
	private Header header;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		act = (MainActivity)activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.activity_sys_setting, container, false);
		initView(v);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	private void initView(View v){
		header = (Header)v.findViewById(R.id.sys_setting_header);
		header.setTitle("系统设置");
	}
}
