package com.his.nurse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.his.nurse.R;
import com.his.nurse.adapter.NursingRecordAdapter;
import com.his.nurse.util.ILog;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyListView;

/**
 * @author gordon
 * 护理记录列表界面
 */
public class NursingRecordListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_nursing_record_list);
        
        initView();
        
        
    }

    private void initView() {
        Header header = (Header) findViewById(R.id.nursing_record_list_header);
        header.setTitle("评估单据");
        header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        findViewById(R.id.nursing_record_list_ll_collect).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NursingRecordListActivity.this, NursingRecordActivity.class));
            }
        });
        
        JazzyListView lvRecords = (JazzyListView) findViewById(R.id.nursing_record_list_lv);
        lvRecords.setAdapter(new NursingRecordAdapter(this));
        ILog.d(lvRecords);
    }
    
}
