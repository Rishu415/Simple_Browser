package com.example.rishu.op;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Rishu on 20-Aug-17.
 */

class web1 extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;

    }
}
