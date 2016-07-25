package com.android.lala;

import android.app.Application;

/**
 * @author sxshi on 2016/7/22.
 * @email:emotiona_xiaoshi@126.com
 * @describe:Describe the function  of the current class
 */
public class LaLaAppaction extends Application {
    public static boolean isLoadLocaldata = true;
    public static boolean isUseHTTPS=false;
    public static boolean DEBUG=true;
    /**
     * 请求数据用此变量来判断是否为开发模式，如果是开发模式会使用模拟数据, 如果是模拟数据模式为true，反则false,默认为false
     */
    public static boolean SAMULATION = false;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
