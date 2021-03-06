package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.dialog.LoadingDialog;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * @author gordon
 * 系统设置界面
 */
public class SysSettingActivity extends BaseFragment implements OnClickListener{
	private MainActivity act;
	private Header header;
	
	
	private Handler handler = new Handler(Looper.getMainLooper());
    private LoadingDialog checkUpdateDialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		act = (MainActivity)activity;
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.activity_sys_setting, container, false);
		initView(v);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	private void initView(View v){
		header = (Header)v.findViewById(R.id.sys_setting_header);
		header.setTitle("系统设置");
		
		View tvFeedback = v.findViewById(R.id.sys_settings_tv_feedback);
		tvFeedback.setOnClickListener(this);
		v.findViewById(R.id.sys_settings_tv_check_update).setOnClickListener(this);
		v.findViewById(R.id.sys_settings_tv_clear_memory).setOnClickListener(this);
		v.findViewById(R.id.sys_settings_tv_set_terminal_id).setOnClickListener(this);
		v.findViewById(R.id.sys_settings_tv_sign_out).setOnClickListener(this);
		v.findViewById(R.id.sys_settings_tv_wifi_connect).setOnClickListener(this);
	}

    @Override
    public void onClick(View v) {
        ILog.d("点击");
        switch(v.getId()) {
        case R.id.sys_settings_tv_feedback:
            feedback();
            break;
        case R.id.sys_settings_tv_check_update:
            checkUpdate();
            break;
        case R.id.sys_settings_tv_clear_memory:
            clearMemory();
            break;
        case R.id.sys_settings_tv_set_terminal_id:
            setTerminalId();
            break;
        case R.id.sys_settings_tv_sign_out:
            signOut();
            break;
        case R.id.sys_settings_tv_wifi_connect:
            wifiConnect();
            break;
        }
    }

    private void wifiConnect() {
        // TODO Auto-generated method stub
        
    }

    private void signOut() {
        act.startActivity(new Intent(act, LoginActivity.class));
        act.finish();
    }

    private void setTerminalId() {
        // TODO Auto-generated method stub
        
    }

    private void clearMemory() {
        
    }
    
    /**
     * 取出当前版本
     * @return
     */
    private int getCurrentVersion() {
        PackageManager pm = act.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(act.getPackageName(), PackageManager.GET_GIDS);
            return info.versionCode;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void checkUpdate() {
        checkUpdateDialog = new LoadingDialog(act);
        checkUpdateDialog.setContentText("检查更新");
        checkUpdateDialog.show();
        handler.postDelayed(new Runnable() {
            
            @Override
            public void run() {
                checkUpdateDialog.cancel();
                Toast.makeText(act, "当前版本已最新", Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }

    private void feedback() {
        
    }
    
    
    
}
