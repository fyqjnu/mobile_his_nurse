package com.his.nurse.activity;

import java.util.ArrayList;
import java.util.List;

import com.his.nurse.R;
import com.his.nurse.adapter.DoctorAdviceInfoAdapter;
import com.his.nurse.adapter.MyPagerAdapter;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.fbutton.FButton;
import com.his.nurse.widget.jazzylistview.JazzyHelper;
import com.his.nurse.widget.jazzylistview.JazzyListView;
import com.his.nurse.widget.tab.TabIndicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
/**
 * 医嘱信息页面
 * @author chuanwangchen
 *
 */
public class DoctorAdviceInfoActivity extends BaseActivity {
	private Header header;
	private TabIndicator doctor_advice_tab_indicator;
	private ViewPager viewpager;
	private List<View> views;
	
	private JazzyListView jazzyListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_advice_info);
		initView();
	}
	
	private void initView(){
		header = (Header)findViewById(R.id.doctor_advice_info_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle(getResources().getString(R.string.nurse_doctor_advice_info));
		
		viewpager = (ViewPager)findViewById(R.id.viewpager);
		views = new ArrayList<View>();
		View view1 = getLayoutInflater().inflate(R.layout.activity_current_doctor_advice, null);
		View view2 = getLayoutInflater().inflate(R.layout.activity_current_doctor_advice, null);
		View view3 = getLayoutInflater().inflate(R.layout.activity_current_doctor_advice, null);
		initCurrentDoctorAdviceList(view1,6);
		initCurrentDoctorAdviceList(view2,9);
		initCurrentDoctorAdviceList(view3,3);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		viewpager.setAdapter(new MyPagerAdapter(views));
		viewpager.setOnPageChangeListener(onPageChangeListener);
		
		doctor_advice_tab_indicator = (TabIndicator)findViewById(R.id.doctor_advice_tab_indicator);
		doctor_advice_tab_indicator.setTabTitle(new String[]{"当日医嘱","长期医嘱","临时医嘱"});
		doctor_advice_tab_indicator.setCurrentItem(viewpager.getCurrentItem());
		doctor_advice_tab_indicator.setViewPager(viewpager);
	};
	
	OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			doctor_advice_tab_indicator.setCurrentItem(arg0);
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}
	};
	
	
	private void initCurrentDoctorAdviceList(View view,int size){
		final FButton btn_today = (FButton)view.findViewById(R.id.btn_today);
		final ImageView iv_today = (ImageView)view.findViewById(R.id.iv_today);
		final FButton btn_yesterday = (FButton)view.findViewById(R.id.btn_yesterday);
		final ImageView iv_yesterday = (ImageView)view.findViewById(R.id.iv_yesterday);
		jazzyListView = (JazzyListView)view.findViewById(R.id.listview);
		jazzyListView.setTransitionEffect(JazzyHelper.SLIDE_IN);
		final DoctorAdviceInfoAdapter doctorAdviceInfoAdapter = new DoctorAdviceInfoAdapter(this);
		doctorAdviceInfoAdapter.setSize(size);
		jazzyListView.setAdapter(doctorAdviceInfoAdapter);
		
		jazzyListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DoctorAdviceInfoActivity.this,DoctorAdviceCheckActivity.class);
				startActivity(intent);
			}
		});
		
		btn_today.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(iv_today.getVisibility() == View.INVISIBLE){
					ILog.d("今日医嘱");
					btn_today.setButtonColor(android.graphics.Color.parseColor("#ff9000"));
					btn_yesterday.setButtonColor(android.graphics.Color.parseColor("#989898"));
					iv_today.setVisibility(View.VISIBLE);
					iv_yesterday.setVisibility(View.INVISIBLE);
					if(viewpager.getCurrentItem() == 0){
						doctorAdviceInfoAdapter.setSize(6);
					}else if(viewpager.getCurrentItem() == 1){
						doctorAdviceInfoAdapter.setSize(9);
					}else if(viewpager.getCurrentItem() == 2){
						doctorAdviceInfoAdapter.setSize(3);
					}
					doctorAdviceInfoAdapter.notifyDataSetChanged();
				}
			}
		});
		
		btn_yesterday.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(iv_yesterday.getVisibility() == View.INVISIBLE){
					ILog.d("昨天医嘱");
					btn_today.setButtonColor(android.graphics.Color.parseColor("#989898"));
					btn_yesterday.setButtonColor(android.graphics.Color.parseColor("#ff9000"));
					iv_today.setVisibility(View.INVISIBLE);
					iv_yesterday.setVisibility(View.VISIBLE);
					if(viewpager.getCurrentItem() == 0){
						doctorAdviceInfoAdapter.setSize(4);
					}else if(viewpager.getCurrentItem() == 1){
						doctorAdviceInfoAdapter.setSize(5);
					}else if(viewpager.getCurrentItem() == 2){
						doctorAdviceInfoAdapter.setSize(2);
					}
					doctorAdviceInfoAdapter.notifyDataSetChanged();
				}
			}
		});
	}
}
