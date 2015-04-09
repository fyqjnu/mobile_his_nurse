package com.his.nurse.activity;

import java.util.ArrayList;
import java.util.List;

import com.his.nurse.R;
import com.his.nurse.adapter.CostListingAdapter;
import com.his.nurse.adapter.MyPagerAdapter;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyListView;
import com.his.nurse.widget.tab.TabIndicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
/**
 * 费用清单页面
 * @author chuanwangchen
 *
 */
public class CostListingActivity extends BaseActivity{
	private Header header;

	private TabIndicator cost_listing_tab_indicator;
	private ViewPager viewpager;
	private List<View> views;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cost_listing);
		initView();
	}

	private void initView(){
		header = (Header)findViewById(R.id.cost_listing_header);
		header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		header.setTitle("费用清单");

		viewpager = (ViewPager)findViewById(R.id.viewpager);
		views = new ArrayList<View>();
		View view1 = getLayoutInflater().inflate(R.layout.activity_total_cost, null);
		View view2 = getLayoutInflater().inflate(R.layout.activity_today_cost, null);
		View view3 = getLayoutInflater().inflate(R.layout.activity_today_cost, null);
		initTodayCostListing(view2);
		initTodayCostListing(view3);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		viewpager.setOffscreenPageLimit(2);
		viewpager.setAdapter(new MyPagerAdapter(views));
		viewpager.setOnPageChangeListener(onPageChangeListener);

		cost_listing_tab_indicator = (TabIndicator)findViewById(R.id.cost_listing_tab_indicator);
		cost_listing_tab_indicator.setTabTitle(new String[]{"总费用","今日费用清单","历史费用清单"});
		cost_listing_tab_indicator.setCurrentItem(viewpager.getCurrentItem());
		cost_listing_tab_indicator.setViewPager(viewpager);
	};

	OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			cost_listing_tab_indicator.setCurrentItem(arg0);

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
	
	/**
	 * 初始化今日清单列表
	 */
	private void initTodayCostListing(View v){
		TextView tv_total_money = (TextView)v.findViewById(R.id.tv_total_money);
		JazzyListView jazzyListView = (JazzyListView)v.findViewById(R.id.listview);
		CostListingAdapter adapter = new CostListingAdapter(this,tv_total_money);
		jazzyListView.setAdapter(adapter);
	}
}
