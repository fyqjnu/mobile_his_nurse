package com.his.nurse.adapter;

import java.util.List;

import com.his.nurse.R;
import com.his.nurse.entity.Patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 病人列表数据
 */
public class PatientAdapter extends BaseAdapter {

    private Context ctx;
    
    private List<Patient> data;
    
    public PatientAdapter(Context ctx) {
        this.ctx = ctx;
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
            view = LayoutInflater.from(ctx).inflate(R.layout.item_patient, null);
            vh = new ViewHolder();
            vh.tvAge = (TextView) view.findViewById(R.id.item_patient_tv_age);
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
            vh.tvSex = (TextView) view.findViewById(R.id.item_patient_tv_sex);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        Patient info = (Patient) getItem(position);
        vh.tvAge.setText(info.age + "岁");
        vh.tvBedNum.setText(info.bedNum);
        vh.tvDangerLevel.setText(info.dangerType);
        vh.tvDays.setText(String.format("在院%d天", info.daysInHospital));
        vh.tvDoctorName.setText(info.doctorName);
        vh.tvFoodType.setText(info.foodType);
        vh.tvId.setText(info.id);
        vh.tvIllType.setText(info.illType);
        vh.tvName.setText(info.name);
        vh.tvPayType.setText(info.payType);
        vh.tvPriority.setText(info.priority);
        vh.tvSex.setText(info.sex);
        return view;
    }
    
    class ViewHolder {
        TextView tvBedNum;
        TextView tvName;
        TextView tvSex;
        TextView tvAge;
        TextView tvDays;
        TextView tvId;
        TextView tvPriority;
        TextView tvFoodType;
        TextView tvPayType;
        TextView tvDangerLevel;
        TextView tvIllType;
        TextView tvDoctorName;
    }

}
