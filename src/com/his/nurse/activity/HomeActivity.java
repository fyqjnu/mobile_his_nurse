package com.his.nurse.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.his.nurse.R;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;

/**
 * 主界面
 */
public class HomeActivity extends BaseActivity implements OnClickListener {

    
    private Header header;
    private PopupWindow pop;
    private TextView tvTaskNum;
    private TextView tvTime;
    private TextView tvDate;
    private BroadcastReceiver timeReceiver;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        initView();
        
        
        IntentFilter filter = new IntentFilter("android.intent.action.TIME_TICK");
        timeReceiver = new TimeReceiver();
        registerReceiver(timeReceiver, filter);
    }
    
    private String getTime() {
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
        return fmt.format(new Date());
    }
    
    private String getDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("M月d日 E");
        return fmt.format(new Date());
    }
    
    private void setTime() {
        tvTime.setText(getTime());
        tvDate.setText(getDate());
    }
    
    private void initView() {
        
        tvTime = (TextView) findViewById(R.id.home_tv_time);
        tvDate = (TextView) findViewById(R.id.home_tv_date);
        setTime();
        tvTime.measure(0, 0);
        tvDate.measure(0, 0);
        ILog.d(tvDate.getMeasuredWidth());
        ILog.d(tvTime.getMeasuredWidth());
        
        LinearLayout llTimeContainerLayout = (LinearLayout) findViewById(R.id.home_ll_time_container);
        int h = (int) (Math.max(tvDate.getMeasuredWidth(), tvTime.getMeasuredWidth()) + 15*getResources().getDisplayMetrics().density);
        llTimeContainerLayout.getLayoutParams().width = h;
        llTimeContainerLayout.getLayoutParams().height = h;
        ILog.d(h);
        
        Bitmap bg = createRoundBitmap(h, 0xcff6efdd);
        llTimeContainerLayout.setBackgroundDrawable(new BitmapDrawable(bg));
        
        
        findViewById(R.id.home_rl_today_task).setOnClickListener(this);
        ImageView ivTodayTask = (ImageView) findViewById(R.id.home_iv_today_task);
        ivTodayTask.measure(0, 0);
        int r = ivTodayTask.getMeasuredHeight();
        int p = 50;
//        ivTodayTask.setPadding(p, p, p, p);
        ivTodayTask.getLayoutParams().width = r;
        ILog.d("r:" + r);
        ivTodayTask.setBackgroundDrawable(new BitmapDrawable(createRoundBitmap(r, 0xcff6efdd)));
        
        header = (Header) findViewById(R.id.home_header);
        header.setTitle("移动医护系统护士端");
        header.setRightImageViewRes(R.drawable.option, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                ILog.d("更多选项");
                showOption();
            }
        });
        
        
        findViewById(R.id.home_ll_infusion).setOnClickListener(this);
        findViewById(R.id.home_ll_drug_verify).setOnClickListener(this);
        findViewById(R.id.home_ll_advice_perform).setOnClickListener(this);
        findViewById(R.id.home_ll_nurse_round).setOnClickListener(this);
        findViewById(R.id.home_ll_patient_info).setOnClickListener(this);
        findViewById(R.id.home_ll_sign_collect).setOnClickListener(this);
        findViewById(R.id.home_ll_time_container).setOnClickListener(this);
        
        tvTaskNum = (TextView) findViewById(R.id.home_tv_task_num);
        
        setTaskNum(32);
    }
    
    private void setTaskNum(int num) {
        tvTaskNum.setText("" + num);
        tvTaskNum.measure(0, 0);
        int d = (int) (Math.max(tvTaskNum.getMeasuredWidth(), tvTaskNum.getMeasuredHeight()) + 5*getResources().getDisplayMetrics().density);
        Bitmap bm = createRoundBitmap(d, Color.RED);
        tvTaskNum.setBackgroundDrawable(new BitmapDrawable(bm));
        
        tvTaskNum.getLayoutParams().width = d;
        tvTaskNum.getLayoutParams().height = d;
        tvTaskNum.setGravity(Gravity.CENTER);
    }
    
    private void showOption() {
        if (pop == null) {
            View view = LayoutInflater.from(this).inflate(R.layout.option, null);
            view.measure(0, 0);
            pop = new PopupWindow(view, view.getMeasuredWidth(), view.getMeasuredHeight(), true);
            pop.setOutsideTouchable(false);
            pop.setTouchable(true);
            pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            
            view.findViewById(R.id.option_ll_change_password).setOnClickListener(this);
            view.findViewById(R.id.option_ll_setting).setOnClickListener(this);
            view.findViewById(R.id.option_ll_sign_out).setOnClickListener(this);
        }
        
        pop.showAsDropDown(header.getRightView());
    }
    
    private void dismissOption() {
        pop.dismiss();
    }

    private Bitmap createRoundBitmap(int d, int color) {
        Bitmap bg = Bitmap.createBitmap(d, d, Config.ARGB_8888);
        Canvas c = new Canvas(bg);
        Paint p = new Paint();
        p.setColor(color);
        c.drawRoundRect(new RectF(new Rect(0, 0, d, d)), d/2, d/2, p);
        return bg;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.home_rl_today_task:
            ILog.d("今日任务");
            Intent intent = new Intent(this, TodayTaskActivity.class);
            startActivity(intent);
            break;
        case R.id.option_ll_change_password:
            ILog.d("改变密码");
            dismissOption();
            break;
        case R.id.option_ll_setting:
            dismissOption();
            break;
        case R.id.option_ll_sign_out:
            dismissOption();
            break;
            
        case R.id.home_ll_drug_verify:
            ILog.d("药品核对");
            startActivity(new Intent(this, CheckDrugActivity.class));
            break;
            
        case R.id.home_ll_infusion:
            ILog.d("输液监控");
            Intent infusion_intent = new Intent(this, InfusionMonitorActivity.class);
            startActivity(infusion_intent);
            break;
        case R.id.home_ll_sign_collect:
        	ILog.d("体征采集");
        	Intent sign_collect_intent = new Intent(this, SignsCollectActivity.class);
            startActivity(sign_collect_intent);
            break;
        case R.id.home_ll_advice_perform:
        	ILog.d("医嘱执行");
        	Intent doctor_advice_intent = new Intent(this, DoctorAdviceInfoActivity.class);
            startActivity(doctor_advice_intent);
            break;
        case R.id.home_ll_patient_info:
            startActivity(new Intent(this, PatientListActivity.class));
            break;
        case R.id.home_ll_nurse_round:
        	Intent nurse_round_intent = new Intent(this, MyPatientActivity.class);
            startActivity(nurse_round_intent);
        	break;
        default:
            break;
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(timeReceiver);
    }
    
    class TimeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ILog.d("action:" + intent.getAction());
            setTime();
        }
        
    }
    
}
