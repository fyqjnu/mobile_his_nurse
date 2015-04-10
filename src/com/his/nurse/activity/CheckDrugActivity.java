package com.his.nurse.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.his.nurse.R;
import com.his.nurse.adapter.CheckDrugAdapter;
import com.his.nurse.adapter.PatientAdapter;
import com.his.nurse.adapter.SimplePageAdapter;
import com.his.nurse.entity.Patient;
import com.his.nurse.util.DensityUtil;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.SearchView;
import com.his.nurse.widget.SearchView.ISearchListener;
import com.his.nurse.widget.jazzylistview.JazzyGridView;
import com.his.nurse.widget.jazzylistview.JazzyHelper;
import com.his.nurse.widget.jazzylistview.JazzyListView;
import com.his.nurse.widget.tab.TabIndicator;

/**
 * 药品核对页面
 */
public class CheckDrugActivity extends BaseActivity implements OnItemClickListener, OnPageChangeListener, ISearchListener {

    
    private ViewPager pager;
    private TabIndicator tabIndicator;
    private String[] titles = new String[]{"拿药", "摆药", "用药"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_check_drug);
        
        initView();
    }

    private void initView() {
        Header header = (Header) findViewById(R.id.check_drug_header);
        header.setTitle("药品核对");
        header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        tabIndicator = (TabIndicator) findViewById(R.id.check_drug_tab_indicator);
        pager = (ViewPager) findViewById(R.id.check_drug_viewPager);
        tabIndicator.setViewPager(pager);
        
        tabIndicator.setTabTitle(titles);
        List<View> views = new ArrayList<View>();
        for (String title:titles) {
            ListView lv = createListView();
            lv.setTag(title);
            views.add(lv);
            lv.setOnItemClickListener(this);
            lv.setAdapter(new CheckDrugAdapter(this));
        }
        pager.setAdapter(new SimplePageAdapter(views));
        pager.setOnPageChangeListener(this);
        tabIndicator.setCurrentItem(pager.getCurrentItem());
    }
    
    private ListView createListView() {
        JazzyListView lv = new JazzyListView(this);
        lv.setTransitionEffect(JazzyHelper.SLIDE_IN);
        lv.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.item_vertical_space));
        SearchView searchView = new SearchView(this);
        searchView.setSearchListener(this);
        lv.addHeaderView(searchView);
        return lv;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Object tag = parent.getTag();
        ILog.d("点击：" + tag);
        
        Intent intent = new Intent(this, CheckDrugDetailActivity.class);
        if (titles[0].equals(tag)) {
            //
        } else if (titles[1].equals(tag)) {
            
        } else if (titles[2].equals(tag)) {
            
        }
        startActivity(intent);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPageSelected(int arg0) {
        tabIndicator.setCurrentItem(arg0);
    }

    @Override
    public void onSearch(String keyWord) {
        int index = pager.getCurrentItem();
        ILog.d("index:" + index + "," + keyWord);
        
    }

    @Override
    public void onScan() {
        int index = pager.getCurrentItem();
        ILog.d("index:" + index + " 扫二维码");
    }
}
