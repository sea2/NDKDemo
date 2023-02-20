#Android.mk
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
# 库名
LOCAL_MODULE := native-lib
# 用到的.c文件
LOCAL_SRC_FILES :=native-lib.c
LOCAL_LDLIBS += -llog

include $(BUILD_SHARED_LIBRARY)
