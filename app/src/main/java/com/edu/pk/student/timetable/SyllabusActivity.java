package com.edu.pk.student.timetable;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

public class SyllabusActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mWebView = (WebView) findViewById(R.id.syllabus_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:(function() { " +
                        "document.getElementById('accordion_outside').style.display='none'; " +
                        "document.getElementById('logo').style.display='none'; " +
                        "document.getElementById('sidebar').style.display='block'; " +
                        "document.getElementById('footer').style.display='none'; " +
                        "})()");
            }
        });
        mWebView.loadUrl("http://syllabus.pk.edu.pl/");

    }

}
