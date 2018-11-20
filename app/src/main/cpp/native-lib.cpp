#include <jni.h>

extern "C"

JNIEXPORT jlong JNICALL
Java_com_webronin_126_android_1native_1calculator_MainActivity_plusIntFromJNI(
        JNIEnv *env
        , jobject instance
        , jint number1
        , jint number2 ) {

    return number1 + number2;

}

extern "C"

JNIEXPORT jlong JNICALL
Java_com_webronin_126_android_1native_1calculator_MainActivity_minusIntFromJNI(
        JNIEnv *env
        , jobject instance
        , jint number1
        , jint number2 ) {

    return number1 - number2;

}

extern "C"

JNIEXPORT jlong JNICALL
Java_com_webronin_126_android_1native_1calculator_MainActivity_multipliedIntFromJNI(
        JNIEnv *env
        , jobject instance
        , jint number1
        , jint number2 ) {

    return number1 * number2;

}

extern "C"

JNIEXPORT jlong JNICALL
Java_com_webronin_126_android_1native_1calculator_MainActivity_dividedIntFromJNI(
        JNIEnv *env
        , jobject instance
        , jint number1
        , jint number2 ) {

    return number1 / number2;

}