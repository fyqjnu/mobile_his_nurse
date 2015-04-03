package com.his.nurse.adapter;

import java.util.List;

import com.his.nurse.R;
import com.his.nurse.entity.Patient;
import com.his.nurse.util.ILog;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

/**
 * 病人列表数据
 */
public class PatientAdapter extends BaseAdapter implements OnItemClickListener, OnClickListener {
    
    private static final String tag_basic_info = "tag_basic_info";
    private static final String tag_cost_detail = "tag_cost_detail";
    private static final String tag_doctor_advice_info = "tag_doctor_advice_info";
    private static final String tag_sign_info = "tag_sign_info";
    private static final String tag_skin_test_result = "tag_skin_test_result";

    private Context ctx;
    
    
    private SparseArray<Integer> displayChildMap = new SparseArray<Integer>();
    
    private List<Patient> data;
    
    public PatientAdapter(Context ctx) {
        this.ctx = ctx;
    }
    
    public PatientAdapter(Context ctx, List<Patient> list) {
        this(ctx);
        this.data = list;
    }
    
    public void setPatientInfo(List<Patient> list) {
        this.data = list;
    }
    
    @Override
    public int getCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh;
        if (view == null) {
            ViewFlipper vf = new ViewFlipper(ctx);
            View top = LayoutInflater.from(ctx).inflate(R.layout.item_patient, null);
            View bottom = LayoutInflater.from(ctx).inflate(R.layout.item_patient_clicked, null);
            vf.addView(top);
            vf.addView(bottom);
            view = vf;
            vh = new ViewHolder();
            vh.tvBedNum = (TextView) view.findViewById(R.id.item_patient_tv_bed_num);
            vh.tvDangerLevel = (TextView) view.findViewById(R.id.item_patient_tv_danger_level);
            vh.tvDays = (TextView) view.findViewById(R.id.item_patient_tv_days);
            vh.tvDoctorName = (TextView) view.findViewById(R.id.item_patient_tv_doctor_name);
            vh.tvFoodType = (TextView) view.findViewById(R.id.item_patient_tv_food_type);
            vh.tvId = (TextView) view.findViewById(R.id.item_patient_tv_id);
            vh.tvIllType = (TextView) view.findViewById(R.id.item_patient_tv_ill_type);
            vh.tvName = (TextView) view.findViewById(R.id.item_patient_tv_name);
            vh.tvPayType = (TextView) view.findViewById(R.id.item_patient_tv_pay_type);
            vh.tvPriority = (TextView) view.findViewById(R.id.item_patient_tv_priority);
            vh.tvSexAge = (TextView) view.findViewById(R.id.item_patient_tv_sex_age);
            
            vh.llBasicInfo = view.findViewById(R.id.item_patient_ll_basic_info);
            vh.llBasicInfo.setOnClickListener(this);
            vh.llBasicInfo.setTag(tag_basic_info);
            ((View)vh.llBasicInfo.getParent()).setTag(position);
            
            vh.llCostDetail = view.findViewById(R.id.item_patient_ll_cost_detail);
            vh.llCostDetail.setOnClickListener(this);
            vh.llCostDetail.setTag(tag_cost_detail);
            vh.llDoctorAdviceInfo = view.findViewById(R.id.item_patient_ll_doctor_advice_info);
            vh.llDoctorAdviceInfo.setOnClickListener(this);
            vh.llDoctorAdviceInfo.setTag(tag_doctor_advice_info);
            vh.llSignInfo = view.findViewById(R.id.item_patient_ll_sign_info);
            vh.llSignInfo.setOnClickListener(this);
            vh.llSignInfo.setTag(tag_sign_info);
            vh.llSkinTestResult = view.findViewById(R.id.item_patient_ll_skin_test_result);
            vh.llSkinTestResult.setOnClickListener(this);
            vh.llSkinTestResult.setTag(tag_skin_test_result);
            
            vh.vf = vf;
            
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        
        int child = displayChildMap.get(position, new Integer(0));
        vh.vf.setDisplayedChild(child);
        
        Patient info = (Patient) getItem(position);
        vh.tvBedNum.setText(info.bedNum);
        vh.tvDangerLevel.setText(info.dangerType);
        vh.tvDays.setText(String.format("在院%d天", info.daysInHospital));
        vh.tvDoctorName.setText("主治医生：" + info.doctorName);
        vh.tvFoodType.setText(info.foodType);
        vh.tvId.setText(info.id);
        String illTypeField = "入院诊断：";
        SpannableStringBuilder sb = new SpannableStringBuilder(illTypeField + info.illType);
        ForegroundColorSpan blackSpan = new ForegroundColorSpan(Color.BLACK);
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
        sb.setSpan(blackSpan, 0, illTypeField.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sb.setSpan(redSpan, illTypeField.length(), sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        
        vh.tvIllType.setText(sb);
        vh.tvName.setText(info.name);
        vh.tvPayType.setText(info.payType);
        vh.tvPriority.setText(info.priority);
        vh.tvSexAge.setText(String.format("%s %d岁", info.sex, info.age));
        
        
        return view;
    }
    
    class ViewHolder {
        
        ViewFlipper vf;
        
        TextView tvBedNum;
        TextView tvName;
        TextView tvSexAge;
        TextView tvDays;
        TextView tvId;
        TextView tvPriority;
        TextView tvFoodType;
        TextView tvPayType;
        TextView tvDangerLevel;
        TextView tvIllType;
        TextView tvDoctorName;
        
        
        View llBasicInfo;
        View llCostDetail;
        View llDoctorAdviceInfo;
        View llSignInfo;
        View llSkinTestResult;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        ViewFlipper vf = (ViewFlipper) view;
        Integer child = displayChildMap.get(position, Integer.valueOf(0));
        if (child == 0) {
            child = 1;
        } else if (child == 1) {
            child = 0;
        }
        vf.setDisplayedChild(child);
        displayChildMap.put(position, child);
    }

    @Override
    public void onClick(View v) {
        ILog.d("点击 " + v.getTag());
        Object tag = v.getTag();
        View parent = (View) v.getParent();
        int position = (Integer) parent.getTag();
        ILog.d("位置:" + position);
        if (tag_basic_info.equals(tag)) {
            //病人基本信息
            
        } else if (tag_cost_detail.equals(tag)) {
            //费用清单
            
        } else if (tag_doctor_advice_info.equals(tag)) {
            //医嘱
            
        } else if (tag_sign_info.equals(tag)) {
            //体征信息
            
        } else if (tag_skin_test_result.equals(tag)) {
            //皮试结果
            
        }
    }

}
