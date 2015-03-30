package com.his.nurse.widget.tab;

import java.util.ArrayList;
import java.util.List;

import com.his.nurse.R;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * tab标题控件
 * 通过setTabTitle设置tab标题名称
 * setViewPager设置关联的viewpager控件
 */
public class TabIndicator extends LinearLayout implements OnClickListener {

    private String[] titles;
    
    private List<TextView> textViews = new ArrayList<TextView>();
    
    private ViewPager pager;

    public TabIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TabIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public TabIndicator(Context context) {
        super(context);
    }
    
    public void setViewPager(ViewPager pager) {
        this.pager = pager;
    }
    
    public void setTabTitle(String[] titles) {
        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundColor(0xffe4e4e4);
        this.titles = titles;
        textViews.clear();
        removeAllViews();
        int index = 0;
        for (String title: titles) {
            TextView tv = createTextView();
            textViews.add(tv);
            tv.setText(title);
            tv.setId(index);
            addView(tv, createLayoutParams());
            tv.setOnClickListener(this);
            
            if (index<titles.length-1) {
                ImageView space = new ImageView(getContext());
                space.setImageResource(R.drawable.vertical_line);
                addView(space );
            }
            index++;
        }
    }
    
    private LinearLayout.LayoutParams createLayoutParams() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, -1);
        lp.weight = 1;
        return lp;
    }
    
    private TextView createTextView() {
        TextView tv = new TextView(getContext());
        tv.setTextSize(20);
        tv.getPaint().setFakeBoldText(true);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
    
    public void setCurrentItem(int index) {
        for (TextView tv:textViews) {
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundDrawable(null);
        }
        textViews.get(index).setTextColor(0xffff5a00);
        textViews.get(index).setBackgroundResource(R.drawable.tab_selected_bg);
    }

    @Override
    public void onClick(View v) {
        int index = v.getId();
        if (pager != null) {
            pager.setCurrentItem(index);
        }
        
        setCurrentItem(index);
    }
    
}
