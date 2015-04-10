package com.his.nurse.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.his.nurse.R;
import com.his.nurse.widget.LeftSlidingMenu;
/**
 * 主页面
 * @author chuanwangchen
 *
 */
public class MainActivity extends  FragmentActivity implements OnClickListener{
	private LeftSlidingMenu menu;
	private RelativeLayout rl_patient_info,rl_fymx,
    rl_inspection_record,rl_check_record,rl_doctor_advice_info,rl_check_drug
    ,rl_pgdj,rl_nursing;
	
	private MyPatientActivity myPatientFragment;
	private InfusionMonitorActivity infusionMonitorFragment;
	private TodayTaskActivity todayTaskFragment;
	private SysSettingActivity sysSettingFragment;

	private RelativeLayout menuTab;//菜单选项卡
	private RelativeLayout myPatientTab;// 病人信息选项卡
	private RelativeLayout infusionMonitorTab;// 输液监控选项卡
	private RelativeLayout todayTaskTab;// 今日任务选项卡
	private RelativeLayout sysSetTab;// 系统设置选项卡

	private ImageView myPatientTabIcon;
	private ImageView infusionMonitorTabIcon;
	private ImageView todayTaskTabIcon;
	private ImageView sysSetTabIcon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initLeftMenu();
		initView();
		initListener();
		myPatientFragment = new MyPatientActivity();
		initFragment(myPatientFragment);
	}

	private void initView(){
		menuTab = (RelativeLayout) findViewById(R.id.menuTab);
		myPatientTab = (RelativeLayout) findViewById(R.id.myPatientTab);
		infusionMonitorTab = (RelativeLayout) findViewById(R.id.infusionMonitorTab);
		todayTaskTab = (RelativeLayout) findViewById(R.id.todayTaskTab);
		sysSetTab = (RelativeLayout) findViewById(R.id.sysSetTab);

		myPatientTabIcon = (ImageView) findViewById(R.id.myPatientTabIcon);
		infusionMonitorTabIcon = (ImageView) findViewById(R.id.infusionMonitorTabIcon);
		todayTaskTabIcon = (ImageView) findViewById(R.id.todayTaskTabIcon);
		sysSetTabIcon = (ImageView) findViewById(R.id.sysSetTabIcon);
	}
	
	private void initLeftMenu(){
		menu = (LeftSlidingMenu)findViewById(R.id.id_menu);
    	rl_patient_info = (RelativeLayout) findViewById(R.id.rl_patient_info);
    	rl_fymx=(RelativeLayout)findViewById(R.id.rl_fymx);
    	rl_inspection_record = (RelativeLayout) findViewById(R.id.rl_inspection_record);
    	rl_check_record = (RelativeLayout) findViewById(R.id.rl_check_record);
    	rl_doctor_advice_info = (RelativeLayout) findViewById(R.id.rl_doctor_advice_info);
    	rl_check_drug = (RelativeLayout) findViewById(R.id.rl_check_drug);
    	rl_pgdj = (RelativeLayout) findViewById(R.id.rl_pgdj);
    	rl_nursing = (RelativeLayout) findViewById(R.id.rl_nursing);
    	
    	rl_patient_info.setOnClickListener(this);
    	rl_fymx.setOnClickListener(this);
    	rl_inspection_record.setOnClickListener(this);
    	rl_check_record.setOnClickListener(this);
    	rl_doctor_advice_info.setOnClickListener(this);
    	rl_check_drug.setOnClickListener(this);
    	rl_pgdj.setOnClickListener(this);
    	rl_nursing.setOnClickListener(this);
    }
	
	private void initListener(){
		menuTab.setOnClickListener(this);
		myPatientTab.setOnClickListener(this);
		infusionMonitorTab.setOnClickListener(this);
		todayTaskTab.setOnClickListener(this);
		sysSetTab.setOnClickListener(this);
	}

	public void changeFragment(Fragment f) {
		changeFragment(f, false);
	}

	public void initFragment(Fragment f) {
		changeFragment(f, true);
	}

	private void changeFragment(Fragment fragment, boolean init) {
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.setCustomAnimations(android.R.anim.fade_in,
				android.R.anim.fade_out);
		transaction.replace(R.id.simple_fragment, fragment);
		if (!init)
			transaction.addToBackStack(null);
		transaction.commitAllowingStateLoss();
	}

	private void setBackground(String tag){
		if(tag.equals("patient_info")){
			myPatientTabIcon
			.setBackgroundResource(R.drawable.nurse_my_patient_select);
			infusionMonitorTabIcon
			.setBackgroundResource(R.drawable.nurse_infusion_monitor_unselect);
			todayTaskTabIcon
			.setBackgroundResource(R.drawable.nurse_today_task_unselect);
			sysSetTabIcon
			.setBackgroundResource(R.drawable.nurse_sys_setting_unselect);
		}else if(tag.equals("infusion_monitor")){
			myPatientTabIcon
			.setBackgroundResource(R.drawable.nurse_my_patient_unselect);
			infusionMonitorTabIcon
			.setBackgroundResource(R.drawable.nurse_infusion_monitor_select);
			todayTaskTabIcon
			.setBackgroundResource(R.drawable.nurse_today_task_unselect);
			sysSetTabIcon
			.setBackgroundResource(R.drawable.nurse_sys_setting_unselect);
		}else if(tag.equals("today_task")){
			myPatientTabIcon
			.setBackgroundResource(R.drawable.nurse_my_patient_unselect);
			infusionMonitorTabIcon
			.setBackgroundResource(R.drawable.nurse_infusion_monitor_unselect);
			todayTaskTabIcon
			.setBackgroundResource(R.drawable.nurse_today_task_select);
			sysSetTabIcon
			.setBackgroundResource(R.drawable.nurse_sys_setting_unselect);
		}else if(tag.equals("sys_setting")){
			myPatientTabIcon
			.setBackgroundResource(R.drawable.nurse_my_patient_unselect);
			infusionMonitorTabIcon
			.setBackgroundResource(R.drawable.nurse_infusion_monitor_unselect);
			todayTaskTabIcon
			.setBackgroundResource(R.drawable.nurse_today_task_unselect);
			sysSetTabIcon
			.setBackgroundResource(R.drawable.nurse_sys_setting_select);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.menuTab:
			menu.toggle();
			break;
		case R.id.myPatientTab:
			myPatientFragment = new MyPatientActivity();
			changeFragment(myPatientFragment);
			setBackground("patient_info");
			break;
		case R.id.infusionMonitorTab:
			infusionMonitorFragment = new InfusionMonitorActivity();
			changeFragment(infusionMonitorFragment);
			setBackground("infusion_monitor");
			break;
		case R.id.todayTaskTab:
			todayTaskFragment = new TodayTaskActivity();
			changeFragment(todayTaskFragment);
			setBackground("today_task");
			break;
		case R.id.sysSetTab:
			sysSettingFragment = new SysSettingActivity();
			changeFragment(sysSettingFragment);
			setBackground("sys_setting");
			break;
		case R.id.rl_patient_info://患者信息
			startActivity(new Intent(this, PatientListActivity.class));
			break;
		case R.id.rl_fymx://费用清单
			startActivity(new Intent(this, CostListingActivity.class));
			break;
		case R.id.rl_inspection_record://检验结果
			
			break;
		case R.id.rl_check_record://检查结果
			
			break;
		case R.id.rl_doctor_advice_info://医嘱列表
			startActivity(new Intent(this, DoctorAdviceInfoActivity.class));
			break;
		case R.id.rl_check_drug://药品核对
			startActivity(new Intent(this, CheckDrugActivity.class));
			break;
		case R.id.rl_pgdj://评估单据
			startActivity(new Intent(this, NursingRecordActivity.class));
			break;
		case R.id.rl_nursing://护理记录
			startActivity(new Intent(this, SignsCollectActivity.class));
			break;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			exitDialog();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	// 退出
	private void exitDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("温馨提示");
		builder.setMessage("真的要走吗?再看看吧！");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				finish();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				dialog.cancel();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
	}
}
