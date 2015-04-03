package com.his.nurse.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.his.nurse.R;
import com.his.nurse.adapter.PatientAdapter;
import com.his.nurse.entity.Patient;
import com.his.nurse.widget.Header;

/**
 * 病人列表
 * @author Administrator
 *
 */
public class PatientListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_patient_list);
        
        initView();
    }

    private void initView() {
        Header header = (Header) findViewById(R.id.patient_list_header);
        header.setTitle("病人信息");
        header.setLeftImageVewRes(R.drawable.back, new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        ListView lvPatient = (ListView) findViewById(R.id.patient_list_listview);
        List<Patient> list = getPatientInfo();
        PatientAdapter adapter = new PatientAdapter(this, list);
        lvPatient.setAdapter(adapter);
        
        lvPatient.setOnItemClickListener(adapter);
    }
    
    private List<Patient> getPatientInfo() {
        Random r = new Random();
        List<Patient> list = new ArrayList<Patient>();
        for (int i=0; i<10;i++) {
            Patient p = new Patient();
            p.age = 20 + r.nextInt(40);
            p.name = "姓名 " + i;
            p.bedNum = "1002";
            p.dangerType = "无危重情况";
            p.daysInHospital = 1 + r.nextInt(100);
            p.doctorName = "小红";
            p.foodType = "清淡食物";
            p.id = "100024";
            p.illType = "肝炎";
            p.payType = "广州医保";
            p.priority = "一级护理";
            p.sex = r.nextInt(2)==1?"男":"女";
            list.add(p);
        }
        return list;
    }
    
}
