package com.kariappa.readmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kariappa.mylibrary.MyClass;
import com.kariappa.readmsg.MessageClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageClass.RunPermission(this);
    }
}