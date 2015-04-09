package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 医嘱执行核对页面
 * @author chuanwangchen
 *
 */
public class DoctorAdviceCheckActivity extends BaseActivity{
	private Header header;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_advice_check);
		initView();
	}
	
	private void initView(){
		header = (Header)findViewById(R.id.doctor_advice_check_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		header.setRightImageViewRes(R.drawable.qr_code, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_doctor_advice_check));
	}
}
