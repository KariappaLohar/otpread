package com.kariappa.readmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.kariappa.mylibrary.MyClass;
import com.kariappa.readmsg.MessageClass;
import com.kariappa.readmsg.MessageListener;
import com.kariappa.readmsg.MessageReceiver;

public class MainActivity extends AppCompatActivity implements MessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MessageReceiver.bindListener(this);
        MessageClass.RunPermission(this);
    }

    @Override
    public void messageReceived(int message) {

        Toast.makeText(this, "NUmber"+message, Toast.LENGTH_SHORT).show();

    }
}