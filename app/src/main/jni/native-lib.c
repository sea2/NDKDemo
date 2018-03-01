#include "com_xcm91_relation_ndkapp_NdkJniUtils.h"
#include <android/log.h>
#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)


JNIEXPORT jstring JNICALL Java_com_xcm91_relation_ndkapp_NdkJniUtils_getStringFromNative(JNIEnv *env, jobject obj,jint x,jint y)

{

    /*   Java类型	类型签名
       boolean	Z
       byte	B
       char	C
       short	S
       int  	I
       long	J
       float	F
       double	D
       类	L全限定类名
       数组	[元素类型签名*/
    //所以 (II)I 表示的意思就是：（整形参数，整形参数）返回值整形   ()V的意思就是：没有参数，没有返回值




    //在c代码里面调用java代码里面的方法
    // java 反射
    //1 . 找到java代码的 class文件
    //    jclass      (*FindClass)(JNIEnv*, const char*);
    jclass dpclazz = (*env)->FindClass(env,"com/xcm91/relation/ndkapp/NdkJniUtils");

    //2 寻找class里面的方法
    //   jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
    jmethodID method1 = (*env)->GetMethodID(env,dpclazz,"helloFromJava","()V");
    //3 .调用这个方法
    //    void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
    (*env)->CallVoidMethod(env,obj,method1);
    LOGI("调用开始");



     //静态方法调用
    jmethodID method4 = (*env)->GetStaticMethodID(env,dpclazz,"callStringMethod","(Ljava/lang/String;)V");
    (*env)->CallStaticVoidMethod(env,dpclazz,method4,(*env)->NewStringUTF(env,"static 方法调用"));


    jmethodID method5 = (*env)->GetStaticMethodID(env, dpclazz,"add", "(II)I");
    LOGI("调用ADD方法的结果count=%d",(*env)->CallStaticIntMethod(env,dpclazz,method5,x,y));



    char buf[] = "HEllO JNI";
    return (*env)->NewStringUTF(env,buf);

}
