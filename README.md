# NDKDemo


c和java的互相调用，包括静态方法，常用方法，使用反射的原理



+ 创建 原生方法
    static {
        System.loadLibrary("native-lib");
    }

    //获取C中隐藏的AppKey
    public native String getStringFromNative(int x, int y); //native




+ 进入cd app/src/main/java然后执行
  javah -d ../jni com.ndkapp.NdkJni
在jni目录生成.h文件

+ jni目录创建.c文件引用.h文件

#include "com_ndkapp_NdkJni.h"


JNIEXPORT jstring JNICALL Java_com_ndkapp_Ndk_getStringFromNative(JNIEnv *env, jobject obj,jint x,jint y)
 {
 return env->NewStringUTF("Hello.Jni~!~!") ;
}
4，创建Android.mk

#Android.mk
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
# 库名
LOCAL_MODULE := native-lib
# 用到的.c文件
LOCAL_SRC_FILES :=native-lib.c
LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)
创建 Applicatio.mk

APP_PLATFORM := android-16
APP_ABI := all
+ 用命令到jni文件夹 用命令   ndk-build生成so文件

+ 将 生成的so文件放入项目
若找不到so文件 在build的android中配置
 sourceSets {
        main {
            jniLibs.srcDirs = ['libs']
        }
    }


