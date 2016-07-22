package com.android.lala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.lala.config.LalaConfig;
import com.android.lala.utils.LalaLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String httpserver= LalaConfig.httpServer;
        LalaLog.i(LalaLog.SSX_TAG,"httpServer:"+httpserver);

    }
}
