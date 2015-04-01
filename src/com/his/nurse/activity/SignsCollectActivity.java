package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Relation;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
/**
 * 体征采集页面
 * @author chuanwangchen
 *
 */
public class SignsCollectActivity extends BaseActivity implements OnClickListener{
	private Header header;
	
	private RelativeLayout rl_in_and_out_amount;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singscollect);
		initView();
		initListener();
	}
	
	private void initView(){
		header = (Header)findViewById(R.id.signscollect_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_signs_collect));
		
		rl_in_and_out_amount = (RelativeLayout)findViewById(R.id.rl_in_and_out_amount);
		
	}
	
	private void initListener(){
		rl_in_and_out_amount.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.rl_in_and_out_amount:
			Intent intent = new Intent(SignsCollectActivity.this,InAndOutAmountActivity.class);
			startActivity(intent);
			break;
		}
	}
}
