package com.fcbox.lib.fcjsbridge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;

import com.fcbox.anglib.fcwebview.base.DownloadListener;
import com.fcbox.anglib.fcwebview.base.IWebSettings;
import com.fcbox.anglib.fcwebview.base.IWebview;
import com.fcbox.anglib.fcwebview.base.ValueCallback;
import com.fcbox.anglib.fcwebview.base.WebChromeClient;
import com.fcbox.anglib.fcwebview.base.WebViewClient;

public class BridgeWebView extends WebView implements IWebview {

  public BridgeWebView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public BridgeWebView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init();
  }

  public BridgeWebView(Context context) {
    super(context);
    init();
  }

  private void init() {
    getSettings().setJavaScriptEnabled(true);
  }

  @Override
  public View getWebview() {
    return this;
  }

  @Override
  public View getView() {
    return null;
  }

  @Override
  public int getContentWidth() {
    return 0;
  }

  @Override
  public void setWebViewClient(WebViewClient webViewClient) {

  }

  @Override
  public void setDownloadListener(DownloadListener downloadListener) {

  }

  @Override
  public void setWebChromeClient(WebChromeClient webChromeClient) {

  }

  @Override
  public void evaluateJavascript(String s, final ValueCallback<String> valueCallback) {
    super.evaluateJavascript(s, new ValueCallback<String>() {
      public void onReceiveValue(String s) {
        valueCallback.onReceiveValue(s);
      }
    });
  }

  @Override
  public IWebSettings getFcWebviewSettings() {
    return null;
  }

  @Override
  public com.fcbox.anglib.fcwebview.base.HitTestResult getFcHitTestResult() {
    return null;
  }
}
