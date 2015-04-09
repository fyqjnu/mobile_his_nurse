package com.his.nurse.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.his.nurse.R;
import com.his.nurse.adapter.PatientAdapter;
import com.his.nurse.adapter.SimplePageAdapter;
import com.his.nurse.entity.Patient;
import com.his.nurse.util.DensityUtil;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.MyViewPager;
import com.his.nurse.widget.SearchView;
import com.his.nurse.widget.SearchView.ISearchListener;
import com.his.nurse.widget.jazzylistview.JazzyHelper;
import com.his.nurse.widget.jazzylistview.JazzyListView;
import com.his.nurse.widget.tab.TabIndicator;

/**
 * 今日任务
 */
public class TodayTaskActivity extends BaseFragment implements OnPageChangeListener, OnItemClickListener, ISearchListener {
    private MainActivity act;
    
    private static final int ID_LV_CHECK_ROOM = 1;
    private static final int ID_LV_CHECK_DRUG = 2;
    private static final int ID_LV_ADVICE_PERFORM = 3;
    private static final int ID_LV_COLLECT_SIGN = 4;
    private TabIndicator tab;
    private List<View> views;
    
    //查房
    private ListView lvCheckRoom;
    
    //核药
    private ListView lvCheckDrug;
    
    //医嘱
    private ListView lvAdvicePerform;
    
    //体征采集
    private ListView lvCollectSign;
    
    @Override
    public void onAttach(Activity activity) {
    	// TODO Auto-generated method stub
    	act = (MainActivity)activity;
    	super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	View v = inflater.inflate(R.layout.activity_today_task, container,
				false);
		initView(v);
    	return v;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onActivityCreated(savedInstanceState);
    }

    private void initView(View v) {
        
        Header header = (Header) v.findViewById(R.id.today_task_header);
        header.setTitle("今日任务");
        
        MyViewPager pager = (MyViewPager) v.findViewById(R.id.today_task_viewPager);
        pager.setOnPageChangeListener(this);
        views = new ArrayList<View>();
        //
        lvCheckRoom = createListView();
        views.add(lvCheckRoom);
        PatientAdapter checkRoomAdapter = new PatientAdapter(act);
        checkRoomAdapter.setPatientInfo(getPatientInfo());
        lvCheckRoom.setAdapter(checkRoomAdapter);
        lvCheckRoom.setOnItemClickListener(this);
        lvCheckRoom.setId(ID_LV_CHECK_ROOM);

        
        lvCheckDrug = createListView();
        views.add(lvCheckDrug);
        PatientAdapter checkDrugAdapter = new PatientAdapter(act);
        checkDrugAdapter.setPatientInfo(getPatientInfo());
        lvCheckDrug.setAdapter(checkDrugAdapter);
        lvCheckDrug.setId(ID_LV_CHECK_DRUG);
        
        lvAdvicePerform = createListView();
        views.add(lvAdvicePerform);
        PatientAdapter advicePerformAdapter = new PatientAdapter(act);
        advicePerformAdapter.setPatientInfo(getPatientInfo());
        lvAdvicePerform.setAdapter(advicePerformAdapter);
        lvAdvicePerform.setId(ID_LV_ADVICE_PERFORM);
        
        lvCollectSign = createListView();
        views.add(lvCollectSign);
        PatientAdapter collectionSignAdapter = new PatientAdapter(act);
        collectionSignAdapter.setPatientInfo(getPatientInfo());
        lvCollectSign.setAdapter(collectionSignAdapter);
        lvCollectSign.setId(ID_LV_COLLECT_SIGN);
        
        
        /*for (int i=0;i<3; i++) {
            TextView tv = new TextView(this);
            tv.setText("pager" + i);
            views.add(tv);
        }*/
        
        pager.setAdapter(new SimplePageAdapter(views));
        
        tab = (TabIndicator) v.findViewById(R.id.today_task_tab_indicator);
        tab.setTabTitle(new String[]{"查房待办", "核药待办", "医嘱执行", "体征采集"});
        tab.setCurrentItem(pager.getCurrentItem());
        tab.setViewPager(pager);
    }
    
    private List<Patient> getPatientInfo() {
        Random r = new Random();
        List<Patient> list = new ArrayList<Patient>();
        for (int i=0; i<10;i++) {
            Patient p = new Patient();
            p.age = 20 + r.nextInt(40);
            p.name = "姓名 " + i;
            p.bedNum = "1002";
            p.dangerType = "无危重情况";
            p.daysInHospital = 1 + r.nextInt(100);
            p.doctorName = "小红";
            p.foodType = "清淡食物";
            p.id = "100024";
            p.illType = "肝炎";
            p.payType = "广州医保";
            p.priority = "一级护理";
            p.sex = r.nextInt(2)==1?"男":"女";
            list.add(p);
        }
        return list;
    }

    private ListView createListView() {
        JazzyListView lv = new JazzyListView(act);
        lv.setTransitionEffect(JazzyHelper.SLIDE_IN);
        lv.setDividerHeight((int) getResources().getDimension(R.dimen.item_vertical_space));
        SearchView searchView = new SearchView(act);
        searchView.setSearchListener(this);
        lv.addHeaderView(searchView);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        switch (parent.getId()) {
        case ID_LV_ADVICE_PERFORM:
            
            break;
        case ID_LV_CHECK_DRUG:
            break;
        case ID_LV_CHECK_ROOM:
            ILog.d("点击查房：" + position);
            break;
        case ID_LV_COLLECT_SIGN:
            break;

        default:
            break;
        }
    }

    @Override
    public void onSearch(String keyWord) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onScan() {
        // TODO Auto-generated method stub
        
    }
    

}
