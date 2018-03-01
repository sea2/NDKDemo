package com.xcm91.relation.ndkapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView sampletext;
    private WebView wvview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.wvview = (WebView) findViewById(R.id.wv_view);
        this.sampletext = (TextView) findViewById(R.id.sample_text);


        wvview.loadUrl("http://www.baidu.com/");


        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        tv.setText(new NdkJniUtils().getStringFromNative(1,2));

    }


}
