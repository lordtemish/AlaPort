package com.dynamica.alaport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.dynamica.alaport.R;

public class WebActivity extends AppCompatActivity {
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        s=getIntent().getStringExtra("url");
        WebView wv=(WebView) findViewById(R.id.webView);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(false);
        wv.loadUrl(s);
    }
}
