package com.his.nurse.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class SimplePageAdapter extends PagerAdapter {

    private List<View> views;
    
    public SimplePageAdapter(List<View> list) {
        this.views = list;
    }

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

    
}
