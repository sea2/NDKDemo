package com.xcm91.relation.ndkapp;

import android.util.Log;

/**
 * Created by lhy on 2017/5/24.
 */

public class NdkJniUtils {

    static {
        System.loadLibrary("native-lib");
    }

    //获取C中隐藏的AppKey
    public native String getStringFromNative(int x, int y); //native方法


    /**
     * 调用带参的Java方法
     *
     * @param x
     * @param y
     * @return
     */
    public static int add(int x, int y) {
        Log.e("TAG", "C中调用JAVA的add");
        return x + y;
    }

    /**
     * 调用JAVA空参数 void返回值的方法
     */
    public static void callNullMethod() {
        Log.e("TAG", "C中调用JAVA的void返回值，空参数方法");
    }

    /**
     * 调用JAVA中String参数和返回值的的方法
     */
    public static void callStringMethod(String str) {
        Log.e("TAG", "callStringMethod调用成功");
    }

    public void helloFromJava() {
        Log.e("TAG", "helloFromJava调用成功");
    }

}
