package com.android.lala;

import android.app.Application;

import com.android.lala.utils.LalaLog;

/**
 * @author sxshi on 2016/7/22.
 * @email:emotiona_xiaoshi@126.com
 * @describe:Describe the function  of the current class
 */
public class LaLaAppaction extends Application {
    public static boolean isLoadLocaldata = true;
    public static boolean isUseHTTPS = false;
    public static boolean SAMULATION = false;
    @Override
    public void onCreate() {
        super.onCreate();
        LalaLog.setDebug(true);
    }
}
