package com.example.recieverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    myDemoReceiver DemoReceiver= new myDemoReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter intentFilter =new IntentFilter("com.example.broadcastapp");
        registerReceiver(DemoReceiver,intentFilter);

        final TextView textView=(TextView) findViewById(R.id.showDataHere);
        Button btnload= (Button) findViewById(R.id.btnload);

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=DemoReceiver.loadData();
                textView.setText(data+"\n");
            }
        });

}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(DemoReceiver);
    }
}
