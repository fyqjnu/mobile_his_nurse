package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
/**
 * 体征采集（出入量）页面
 * @author chuanwangchen
 *
 */
public class InAndOutAmountActivity extends BaseActivity implements OnClickListener{
	private Header header;
	private LinearLayout ll_in_and_out_amount;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_in_and_out_amount);
		initView();
		initListener();
	}
	
	private void initView(){
		header = (Header)findViewById(R.id.in_and_out_amount_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_in_and_out_amount));
		
		ll_in_and_out_amount = (LinearLayout)findViewById(R.id.ll_in_and_out_amount);
	}
	
	private void initListener(){
		ll_in_and_out_amount.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.ll_in_and_out_amount:
			Intent intent = new Intent(InAndOutAmountActivity.this,InAndOutAmountCollectActivity.class);
			startActivity(intent);
			break;
		}
	}
}
