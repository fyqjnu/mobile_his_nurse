package com.his.nurse.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.his.nurse.R;
import com.his.nurse.adapter.MyPatientAdapter;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyGridView;
import com.his.nurse.widget.jazzylistview.JazzyHelper;
/**
 * 我的病人页面
 * @author chuanwangchen
 *
 */
public class MyPatientActivity extends BaseFragment{
	private MainActivity act;
	private Header header;
	
	private JazzyGridView jazzyGridView;
	private MyPatientAdapter adapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		act = (MainActivity) activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.activity_my_patient, container,
				false);
		initView(v);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initListener();
	}
	
	private void initView(View v){
		header = (Header)v.findViewById(R.id.my_patient_header);
		header.setTitle(getResources().getString(R.string.nurse_my_patient));
		
		jazzyGridView = (JazzyGridView)v.findViewById(android.R.id.list);
		jazzyGridView.setTransitionEffect(JazzyHelper.SLIDE_IN);
		adapter = new MyPatientAdapter(act);
		jazzyGridView.setAdapter(adapter);
	}
	
	private void initListener(){
		jazzyGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position%4 == 2){
					Toast.makeText(act, "该床位暂无病人", Toast.LENGTH_SHORT).show();
				}else{
					Intent intent = new Intent(act,DoctorAdviceInfoActivity.class);
					startActivity(intent);
				}
			}
		});
	}
}
