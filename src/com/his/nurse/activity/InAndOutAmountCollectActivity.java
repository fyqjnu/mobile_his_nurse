package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 出入量采集页面
 * @author chuanwangchen
 *
 */
public class InAndOutAmountCollectActivity extends BaseActivity{
	private Header header;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_in_and_out_amount_collect);
		initView();
	}
	
	private void initView(){
		header = (Header)findViewById(R.id.in_and_out_amount_collect_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_in_and_out_amount_collect));
	}
}
