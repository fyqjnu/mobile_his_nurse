package com.his.nurse.util;


/**
 * 日志工具
 */
public class ILog {
    private static final boolean DEBUG = true;
    private static final  String TAG = "his_nurse";

    public static void d(Object obj) {
        if (DEBUG) {
            Throwable t = new Throwable();
            t.fillInStackTrace();
            StackTraceElement[] eles = t.getStackTrace();
            StackTraceElement ele = eles[1];
            String s = ele.getClassName() + "." + ele.getMethodName() + "("
                    + "Line" + ele.getLineNumber() + ")|";
            android.util.Log.d(TAG, s + (obj==null?"":obj.toString()));
        }
    }
    
}
