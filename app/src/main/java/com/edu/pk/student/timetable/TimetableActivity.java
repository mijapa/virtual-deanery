package com.edu.pk.student.timetable;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;

public class TimetableActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mWebView = (WebView) findViewById(R.id.timetable_webview);
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
                        "document.getElementById('skip').style.display='none'; " +
                        "document.getElementById('header').style.display='none'; " +
                        "document.getElementById('top').style.display='none'; " +
                        "document.getElementById('nav').style.display='none'; " +
                        "document.getElementById('footer').style.display='none'; " +
                        "document.getElementById('tools').style.display='none'; " +
                        "document.getElementById('sidebar').style.display='none'; " +
                        "document.getElementById('vcard_wieik').style.display='none'; " +
                        "document.getElementById('nav_top').style.display='none'; " +
                        "document.getElementById('breadcrumb').style.display='none'; " +
                        "})()");
            }
        });
        mWebView.loadUrl("http://wieik.pk.edu.pl/studia/studia-stacjonarne/harmonogramy-zaj-dydaktycznych-na-rok-akademicki-201819/");
    }

}
