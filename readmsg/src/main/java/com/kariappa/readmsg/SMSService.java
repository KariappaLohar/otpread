package com.kariappa.readmsg;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class SMSService extends Service {



    static MessageReceiver myReceiver;
    static IntentFilter intentFilter;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        intentFilter = new IntentFilter();
        intentFilter.addAction(getPackageName() + "android.provider.Telephony.SMS_RECEIVED");
        myReceiver = new MessageReceiver();
        registerReceiver(myReceiver, intentFilter);
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        if(myReceiver!=null){

            // Unregister the SMS receiver
            unregisterReceiver(myReceiver);
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
