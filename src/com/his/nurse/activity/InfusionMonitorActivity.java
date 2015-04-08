package com.his.nurse.activity;

import com.his.nurse.R;
import com.his.nurse.adapter.InfusionMonitorAdapter;
import com.his.nurse.util.DensityUtil;
import com.his.nurse.util.TestLocalData;
import com.his.nurse.widget.Header;
import com.his.nurse.widget.jazzylistview.JazzyGridView;
import com.his.nurse.widget.jazzylistview.JazzyHelper;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * 输液监控页面
 * 
 * @author chuanwangchen
 * 
 */
public class InfusionMonitorActivity extends BaseFragment implements OnItemClickListener {
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
        gvBottle.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Dialog dialog = new Dialog(act);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View v = LayoutInflater.from(act).inflate(R.layout.dialog_bottle_clicked, null);
        int w = (int) (DensityUtil.getScreenWidth(act)*0.7f);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(w, -2);
        dialog.setContentView(v, lp);
        dialog.show();
    }
}
