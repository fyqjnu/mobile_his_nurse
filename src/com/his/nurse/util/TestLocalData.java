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
    
    static String s = "麦凤英子,黄炽昌,麦凤英,周光永,周云华,邓志荣,曾成全,杨秀华,陆友娟,何启群,王红梅,曾富根,邓八妹,霍顺婷,王志,廖仙秀,黎建森,黄达坚,杨丽芳,向延望,黄少芳";
    static String[] names;
    static {
        names = s.split(",");
    }
	
	public static List<Patient> getPatientInfo(int sise) {
        Random r = new Random();
        List<Patient> list = new ArrayList<Patient>();
        for (int i=0; i<names.length;i++) {
            Patient p = new Patient();
            p.age = 20 + r.nextInt(40);
            p.name = names[i];
            p.bedNum = (1001 + i) + "";
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
