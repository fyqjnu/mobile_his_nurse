package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.R.layout;
import com.his.nurse.util.DensityUtil;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 登录页面
 */
public class LoginActivity extends BaseActivity implements OnClickListener {
	private ImageView login_iv_top_icon;
	private EditText login_et_account,login_et_pwd;
	private ImageView login_iv_spiner;
	private LinearLayout login_ll_account,login_ll_pwd,login_ll_enter;
	private TextView login_tv_forget_pwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		initListener();
	}

	private void initView(){
		login_iv_top_icon = (ImageView)findViewById(R.id.login_iv_top_icon);
		RelativeLayout.LayoutParams rl_top_icon = new RelativeLayout.LayoutParams(DensityUtil.getScreenWidth(this),
				DensityUtil.getScreenHeight(this)*500/1280);
		login_iv_top_icon.setLayoutParams(rl_top_icon);

		login_et_account = (EditText)findViewById(R.id.login_et_account);
		login_et_pwd = (EditText)findViewById(R.id.login_et_pwd);
		login_iv_spiner = (ImageView)findViewById(R.id.login_iv_spiner);
		
		login_ll_account = (LinearLayout)findViewById(R.id.login_ll_account);
		RelativeLayout.LayoutParams rl_account = new RelativeLayout.LayoutParams(DensityUtil.getScreenWidth(this)*520/720,
				DensityUtil.getScreenHeight(this)*97/1280);
		rl_account.topMargin = DensityUtil.dip2px(this, 15);
		rl_account.addRule(RelativeLayout.BELOW, R.id.login_tv_title);
		rl_account.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		login_ll_account.setLayoutParams(rl_account);
		
		login_ll_pwd = (LinearLayout)findViewById(R.id.login_ll_pwd);
		RelativeLayout.LayoutParams rl_pwd = new RelativeLayout.LayoutParams(DensityUtil.getScreenWidth(this)*520/720,
				DensityUtil.getScreenHeight(this)*97/1280);
		rl_pwd.topMargin = DensityUtil.dip2px(this, 15);
		rl_pwd.addRule(RelativeLayout.BELOW, R.id.login_ll_account);
		rl_pwd.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		login_ll_pwd.setLayoutParams(rl_pwd);
		
		login_ll_enter = (LinearLayout)findViewById(R.id.login_ll_enter);
		RelativeLayout.LayoutParams rl_enter = new RelativeLayout.LayoutParams(DensityUtil.getScreenWidth(this)*520/720,
				DensityUtil.getScreenHeight(this)*97/1280);
		rl_enter.topMargin = DensityUtil.dip2px(this, 15);
		rl_enter.addRule(RelativeLayout.BELOW, R.id.login_ll_pwd);
		rl_enter.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		login_ll_enter.setLayoutParams(rl_enter);

		login_tv_forget_pwd = (TextView)findViewById(R.id.login_tv_forget_pwd);
		login_tv_forget_pwd.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
	}

	private void initListener(){
		login_iv_spiner.setOnClickListener(this);
		login_ll_enter.setOnClickListener(this);
		login_tv_forget_pwd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.login_iv_spiner:

			break;
		case R.id.login_ll_enter:
			Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
			startActivity(intent);
			break;
		case R.id.login_tv_forget_pwd:

			break;
		}
	}

}
