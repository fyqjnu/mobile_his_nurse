package com.his.nurse.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.his.nurse.R;
import com.his.nurse.adapter.CheckDrugDetailAdapter;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyHelper;
import com.his.nurse.widget.jazzylistview.JazzyListView;

/**
 * @author gordon
 *  药品核对详细界面
 */
public class CheckDrugDetailActivity extends BaseActivity {
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_check_drug_detail);
        initView();
    }

    private void initView() {
        Header header = (Header) findViewById(R.id.check_drug_detail_header);
        header.setTitle("个人药品核对");
        header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        header.setRightImageViewRes(R.drawable.qr_code, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                ILog.d("启动二维码扫码");
            }
        });
        
        JazzyListView lvDrugs = (JazzyListView) findViewById(R.id.check_drug_detailz_lv_drugs);
        lvDrugs.setTransitionEffect(JazzyHelper.SLIDE_IN);
        lvDrugs.setAdapter(new CheckDrugDetailAdapter(this));
    }
    

}
