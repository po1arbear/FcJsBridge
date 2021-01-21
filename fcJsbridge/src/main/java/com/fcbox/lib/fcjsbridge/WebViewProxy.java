package com.fcbox.lib.fcjsbridge;

import android.view.View;
import android.webkit.WebView;
import com.fcbox.anglib.fcwebview.base.IWebview;
import com.fcbox.anglib.fcwebview.base.ValueCallback;

/**
 * @Description: WebView代理，兼容系统WebView
 * @Author: xiongzhuang@fcbox.com
 * @Date: 2021/1/21 5:21 PM
 * @License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box,
 * and it is prohibited to leak or used for other commercial purposes.
 */
class WebViewProxy {

  private final View mWebView;


  public WebViewProxy(View webView) {
    this.mWebView = webView;
  }


  public View getWebview() {
    return mWebView;
  }

  public void evaluateJavascript(String var1, ValueCallback<String> var2) {
    if (mWebView instanceof IWebview) {
      IWebview iWebview = (IWebview) mWebView;
      iWebview.evaluateJavascript(var1, var2);
    } else if (mWebView instanceof WebView) {
      WebView webView = (WebView) mWebView;
      webView.evaluateJavascript(var1, var2);
    }
  }

  public void loadUrl(String url) {
    if (mWebView instanceof IWebview) {
      IWebview iWebview = (IWebview) mWebView;
      iWebview.loadUrl(url);
    } else if (mWebView instanceof WebView) {
      WebView webView = (WebView) mWebView;
      webView.loadUrl(url);
    }
  }

}
