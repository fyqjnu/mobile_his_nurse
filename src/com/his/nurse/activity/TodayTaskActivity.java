package com.his.nurse.activity;

import com.his.nurse.widget.tab.TabIndicator;

import android.os.Bundle;
import android.widget.LinearLayout;

public class TodayTaskActivity extends BaseActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);
        TabIndicator tab = new TabIndicator(this);
        tab.setTabTitle(new String[]{"tab1", "tab2", "tab3", "tab4"});
        layout.addView(tab, -1, 200);
        tab.setCurrentItem(1);
        
    }

}
