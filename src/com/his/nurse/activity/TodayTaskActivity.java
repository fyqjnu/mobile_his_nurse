package com.his.nurse.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.his.nurse.R;
import com.his.nurse.adapter.PatientAdapter;
import com.his.nurse.entity.Patient;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.tab.TabIndicator;

/**
 * 今日任务
 */
public class TodayTaskActivity extends BaseActivity implements OnPageChangeListener {
    
    
    private TabIndicator tab;
    private List<View> views;
    
    //查房
    private ListView lvCheckRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_today_task);
        
        initView();
        
    }

    private void initView() {
        
        Header header = (Header) findViewById(R.id.today_task_header);
        header.setTitle("今日任务");
        header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        ViewPager pager = (ViewPager) findViewById(R.id.today_task_viewPager);
        pager.setOnPageChangeListener(this);
        views = new ArrayList<View>();
        lvCheckRoom = createListView();
        views.add(lvCheckRoom);
        PatientAdapter checkRoomAdapter = new PatientAdapter(this);
        checkRoomAdapter.setPatientInfo(getPatientInfo());
        lvCheckRoom.setAdapter(checkRoomAdapter);
        for (int i=0;i<3; i++) {
            TextView tv = new TextView(this);
            tv.setText("pager" + i);
            views.add(tv);
        }
        
        pager.setAdapter(new PagerAdapter() {
            
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position), -1, -1);
                return views.get(position);
            }
            
            @Override
            public void destroyItem(ViewGroup container, int position,
                    Object object) {
                container.removeView(views.get(position));
            }
            
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
            
            @Override
            public int getCount() {
                return views.size();
            }
        });
        
        tab = (TabIndicator) findViewById(R.id.today_task_tab_indicator);
        tab.setTabTitle(new String[]{"查房待办", "核药待办", "医嘱执行", "体征采集"});
        tab.setCurrentItem(pager.getCurrentItem());
        tab.setViewPager(pager);
    }
    
    private List<Patient> getPatientInfo() {
        List<Patient> list = new ArrayList<Patient>();
        for (int i=0; i<10;i++) {
            Patient p = new Patient();
            p.age = 20 + new Random().nextInt(40);
            p.name = "姓名 " + i;
            p.bedNum = "1002";
            p.dangerType = "无危重情况";
            p.daysInHospital = 10;
            p.doctorName = "小红";
            p.foodType = "清淡食物";
            p.id = "100024";
            p.illType = "肝炎";
            p.payType = "广州医保";
            p.priority = "一级护理";
            p.sex = new Random().nextInt(1)==1?"男":"女";
            list.add(p);
        }
        return list;
    }

    private ListView createListView() {
        ListView lv = new ListView(this);
        return lv;
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        
    }

    @Override
    public void onPageSelected(int index) {
        tab.setCurrentItem(index);
    }
    

}
