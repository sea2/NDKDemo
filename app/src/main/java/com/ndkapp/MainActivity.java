package com.ndkapp;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private TextView sampletext;
    private WebView wvview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.wvview = (WebView) findViewById(R.id.wv_view);
        this.sampletext = (TextView) findViewById(R.id.sample_text);


        wvview.loadUrl("https://www.baidu.com/");


        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        tv.setText(new NdkJni().getStringFromNative(1,2));

    }


}
