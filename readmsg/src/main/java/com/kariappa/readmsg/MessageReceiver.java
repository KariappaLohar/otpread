package com.kariappa.readmsg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.regex.Pattern;

public class MessageReceiver extends BroadcastReceiver {

    private static MessageListener mListener;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();
        Object[] pdus = (Object[]) data.get("pdus");
        for(int i=0; i<pdus.length; i++){
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            if(isNumeric(smsMessage.getMessageBody())){
                mListener.messageReceived(Integer.parseInt(smsMessage.getMessageBody()));
            }else {
                mListener.messageReceived(-1);
            }
        }

    }
    public boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void bindListener(MessageListener listener){
        mListener = listener;
    }
}
