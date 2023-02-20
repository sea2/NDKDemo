package com.ndkapp;

import android.util.Log;

/**
 * Created by lhy on 2017/5/24.
 */

public class NdkJni {

    static {
        System.loadLibrary("native-lib");
    }

    //获取C中隐藏的AppKey
    public native String getStringFromNative(int x, int y); //native


    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static int add(int x, int y) {
        Log.e("NdkJni","c文件调用 add x="+x+"---- y="+y);
        return x + y;
    }

    /**
     */
    public static void callNullMethod() {

        Log.e("NdkJni","c文件调用 callNullMethod");
    }

    /**
     */
    public static void callStringMethod(String str) {
        Log.e("NdkJni","c文件调用 callStringMethod"+str);
    }

    public void helloFromJava() {
        Log.e("NdkJni","c文件调用 helloFromJava");
    }

}
