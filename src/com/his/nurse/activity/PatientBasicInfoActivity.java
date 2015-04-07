package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
/**
 * 病人信息页面
 * @author chuanwangchen
 *
 */
public class PatientBasicInfoActivity extends BaseActivity implements OnClickListener{
	private Header header;
	private LinearLayout ll_hljb,ll_gmxx,ll_wzjb,ll_zzys,ll_ysjy,ll_ryzd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_basic_info);
		initView();
		initListener();
	}

	private void initView(){
		header = (Header)findViewById(R.id.patient_basic_info_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_patient_info));

		ll_hljb = (LinearLayout)findViewById(R.id.ll_hljb);
		ll_gmxx = (LinearLayout)findViewById(R.id.ll_gmxx);
		ll_wzjb = (LinearLayout)findViewById(R.id.ll_wzjb);
		ll_zzys = (LinearLayout)findViewById(R.id.ll_zzys);
		ll_ysjy = (LinearLayout)findViewById(R.id.ll_ysjy);
		ll_ryzd = (LinearLayout)findViewById(R.id.ll_ryzd);
	}

	private void initListener(){
		ll_hljb.setOnClickListener(this);
		ll_gmxx.setOnClickListener(this);
		ll_wzjb.setOnClickListener(this);
		ll_zzys.setOnClickListener(this);
		ll_ysjy.setOnClickListener(this);
		ll_ryzd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.ll_hljb:

			break;
		case R.id.ll_gmxx:

			break;
		case R.id.ll_wzjb:

			break;
		case R.id.ll_zzys:

			break;
		case R.id.ll_ysjy:

			break;
		case R.id.ll_ryzd:

			break;
		}
	}
}
