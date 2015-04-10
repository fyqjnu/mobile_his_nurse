package com.his.nurse.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.his.nurse.R;
import com.his.nurse.widget.Header;

/**
 * @author gordon
 * 添加护理记录界面
 */
public class NursingRecordActivity extends BaseActivity {
    
    private static final String url = "http://www.sojump.com/jq/4705709.aspx";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_nursing_record);
        
        initView();
    }

    private void initView() {
        Header header = (Header) findViewById(R.id.nursing_record_header);
        header.setTitle("个人护理评估单");
        header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        WebView wv = (WebView) findViewById(R.id.nursing_record_wv);
        
        wv.getSettings().setJavaScriptEnabled(true);
        
        wv.setWebChromeClient(new WebChromeClient());
        
        wv.setWebViewClient(new WebViewClient());
        
        wv.loadUrl(url);
        
    }
    

}
