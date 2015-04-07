package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 体征采集详情单页面
 * @author chuanwangchen
 *
 */
public class SignsCollectDetailActivity extends BaseActivity{
	private Header header;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signscollect_detail);
		initView();
	}
	
	private void initView(){
		header = (Header)findViewById(R.id.signs_collect_detail_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_signs_collect_detail));
	}
}
