package com.his.nurse.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.his.nurse.entity.Patient;

/**
 * @author gordon
 * 本地模拟数据
 */
public class TestLocalData {
	
	public static List<Patient> getPatientInfo(int sise) {
        Random r = new Random();
        List<Patient> list = new ArrayList<Patient>();
        for (int i=0; i<sise;i++) {
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
            p.infusionProgress = r.nextInt(101);
            list.add(p);
        }
        return list;
    }

}
