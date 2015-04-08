package com.his.nurse.entity;

/**
 * 病人信息
 */
public class Patient {
    /**
     * 病人id
     */
    public String id;
    public String name;
    public int age;
    public String sex;
    
    /**
     * 床位号
     */
    public String bedNum;
    
    /**
     * 在院天数
     */
    public int daysInHospital;
    
    /**病重情况
     * 
     */
    public String dangerType;
    
    /**饮食类型
     * 
     */
    public String foodType;
    
    /**
     * 支付类型:医保
     */
    public String payType;
    
    /**
     * 病种
     */
    public String illType;
    
    /**
     * 主管医生
     */
    public String doctorName;
    
    /**
     * 护理等级：一级护理
     */
    public String priority;
    
    /**
     * 输液进度
     */
    public int infusionProgress;
    
    
}
