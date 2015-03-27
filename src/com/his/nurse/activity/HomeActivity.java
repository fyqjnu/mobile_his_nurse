package com.his.nurse.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.his.nurse.R;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;

/**
 * 主界面
 */
public class HomeActivity extends BaseActivity implements OnClickListener {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        initView();
    }
    
    private String getTime() {
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
        return fmt.format(new Date());
    }
    
    private String getDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("M月d日 E");
        return fmt.format(new Date());
    }

    private void initView() {
        
        TextView tvTime = (TextView) findViewById(R.id.home_tv_time);
        tvTime.setText(getTime());
        TextView tvDate = (TextView) findViewById(R.id.home_tv_date);
        tvDate.setText(getDate());
        tvTime.measure(0, 0);
        tvDate.measure(0, 0);
        ILog.d(tvDate.getMeasuredWidth());
        ILog.d(tvTime.getMeasuredWidth());
        
        LinearLayout llTimeContainerLayout = (LinearLayout) findViewById(R.id.home_ll_time_container);
        int h = (int) (Math.max(tvDate.getMeasuredWidth(), tvTime.getMeasuredWidth()) + 15*getResources().getDisplayMetrics().density);
        llTimeContainerLayout.getLayoutParams().width = h;
        llTimeContainerLayout.getLayoutParams().height = h;
        ILog.d(h);
        
        Bitmap bg = createRoundBitmap(h);
        llTimeContainerLayout.setBackgroundDrawable(new BitmapDrawable(bg));
        
        ImageView ivTodayTask = (ImageView) findViewById(R.id.home_iv_today_task);
        ivTodayTask.setOnClickListener(this);
        ivTodayTask.measure(0, 0);
        int r = ivTodayTask.getMeasuredHeight();
        int p = 50;
//        ivTodayTask.setPadding(p, p, p, p);
        ivTodayTask.getLayoutParams().width = r;
        ILog.d("r:" + r);
        ivTodayTask.setBackgroundDrawable(new BitmapDrawable(createRoundBitmap(r)));
        
        Header header = (Header) findViewById(R.id.home_header);
        header.setTitle("移动医护系统护士端");
        header.setRightImageViewRes(R.drawable.option, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                ILog.d("更多选项");
            }
        });
    }

    private Bitmap createRoundBitmap(int h) {
        Bitmap bg = Bitmap.createBitmap(h, h, Config.ARGB_8888);
        Canvas c = new Canvas(bg);
        Paint p = new Paint();
        p.setColor(0xcff6efdd);
        c.drawRoundRect(new RectF(new Rect(0, 0, h, h)), h/2, h/2, p);
        return bg;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.home_iv_today_task:
            ILog.d("今日任务");
            
            break;

        default:
            break;
        }
    }
    
}
