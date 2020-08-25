package com.fcbox.lib.fcjsbridge;

import android.view.View;
import android.webkit.ValueCallback;

public interface IWebView {
    View getWebview();

    void loadUrl(String url);

    void evaluateJavascript(String url, ValueCallback<String> value);
}
