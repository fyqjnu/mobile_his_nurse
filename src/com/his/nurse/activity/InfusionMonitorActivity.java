package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.adapter.InfusionMonitorAdapter;
import com.his.nurse.util.TestLocalData;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyGridView;
import com.his.nurse.widget.jazzylistview.JazzyHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.GridView;

/**
 * 输液监控页面
 * 
 * @author chuanwangchen
 * 
 */
public class InfusionMonitorActivity extends BaseFragment {
    private MainActivity act;
    private Header header;

    private JazzyGridView gvBottle;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        act = (MainActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v = inflater.inflate(R.layout.activity_infusion_monitor,
                container, false);
        initView(v);
        gvBottle = (JazzyGridView) v.findViewById(R.id.infusion_monitor_gv);
        gvBottle.setTransitionEffect(JazzyHelper.SLIDE_IN);
        gvBottle.setAdapter(new InfusionMonitorAdapter(act, TestLocalData
                .getPatientInfo(20)));
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(View v) {
        header = (Header) v.findViewById(R.id.infusion_monitor_header);
        header.setTitle(getResources().getString(
                R.string.nurse_infusion_monitor));
    }
}
