package com.example.recieverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.webkit.WebView;
import android.widget.Toast;


public class myDemoReceiver extends BroadcastReceiver {
    public static String receivedMessage ;
    private static Context context;
    public static final String TEXT = "text";
    public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    public void onReceive(Context context, Intent intent) {
    if("com.example.broadcastapp".equals(intent.getAction())){
        receivedMessage  = intent.getStringExtra("message");

        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        String text = sharedPreferences.getString(TEXT, "");
        receivedMessage=text+"\n"+receivedMessage;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, receivedMessage);
        editor.commit();
        this.context = context;
    }
    }

    public String loadData() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String text = sharedPreferences.getString(TEXT, "");
        return text;
    }


}
