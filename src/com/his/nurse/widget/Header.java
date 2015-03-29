package com.his.nurse.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.his.nurse.R;
import com.his.nurse.util.ILog;

/**
 * 页面标题公用控件
 */
public class Header extends RelativeLayout {
    
    private View rightView;
    private View leftView;

    public Header(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Header(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    public Header(Context context) {
        super(context);
        init();
    }
    
    private void init() {
         setBackgroundColor(0xff54d091);
         int p = (int) (getResources().getDisplayMetrics().density * 10);
         setPadding(p, 0, p, 0);
    }
    
    public void setTitle(String text) {
        ILog.d("设置标题：" + text); 
        TextView tv = new TextView(getContext());
        tv.setTextSize(23);
        tv.setTextColor(Color.WHITE);
        tv.setText(text);
        tv.getPaint().setFakeBoldText(true);
        setTitleView(tv);
    }
    
    public void setTitleView(View view) {
        RelativeLayout.LayoutParams viewLp = new RelativeLayout.LayoutParams(-2, -2);
        viewLp.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(view, viewLp);
    }
    
    public void setRightView(View view, OnClickListener listener) {
        RelativeLayout.LayoutParams ivLp = new RelativeLayout.LayoutParams(-2, -1);
        ivLp.addRule(RelativeLayout.CENTER_VERTICAL);
        ivLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(view, ivLp);
        view.setOnClickListener(listener);
        view.setBackgroundResource(R.drawable.pressed_selector);
        rightView = view;
    }

    public void setRightImageViewRes(int res, OnClickListener listener) {
        ImageView iv = new ImageView(getContext());
        iv.setImageResource(res);
        setRightView(iv, listener);
    }
    
    public View getRightView() {
        return rightView;
    }
    
    public void setLeftView(View view, OnClickListener listener) {
        RelativeLayout.LayoutParams ivLp = new RelativeLayout.LayoutParams(-2, -1);
        ivLp.addRule(RelativeLayout.CENTER_VERTICAL);
        ivLp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        addView(view, ivLp);
        view.setOnClickListener(listener);
        leftView = view;
    }
    
    public void setLeftImageVewRes(int res, OnClickListener listener) {
        ImageView iv = new ImageView(getContext());
        iv.setImageResource(res);
        setLeftView(iv, listener);
    }
    
}
