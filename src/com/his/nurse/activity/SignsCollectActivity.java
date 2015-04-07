package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.adapter.SignsCollectAdapter;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyListView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Relation;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/**
 * 体征采集页面
 * @author chuanwangchen
 *
 */
public class SignsCollectActivity extends BaseActivity implements OnClickListener{
	private Header header;
	private LinearLayout ll_collect;
	private RelativeLayout rl_in_and_out_amount;
	
	private JazzyListView jazzyListView;
	private SignsCollectAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signscollect);
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
		
		ll_collect = (LinearLayout)findViewById(R.id.ll_collect);
		rl_in_and_out_amount = (RelativeLayout)findViewById(R.id.rl_in_and_out_amount);
		
		jazzyListView = (JazzyListView)findViewById(R.id.listview);
		adapter = new SignsCollectAdapter(this);
		adapter.setSize(12);
		jazzyListView.setAdapter(adapter);
		
	}
	
	private void initListener(){
		ll_collect.setOnClickListener(this);
		rl_in_and_out_amount.setOnClickListener(this);
		jazzyListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignsCollectActivity.this,SignsCollectDetailActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.rl_in_and_out_amount:
			Intent in_and_out_amount_intent = new Intent(SignsCollectActivity.this,InAndOutAmountActivity.class);
			startActivity(in_and_out_amount_intent);
			break;
		case R.id.ll_collect:
			Intent collect_intent = new Intent(SignsCollectActivity.this,SignsCollectFormActivity.class);
			startActivity(collect_intent);
			break;
		}
	}
}
