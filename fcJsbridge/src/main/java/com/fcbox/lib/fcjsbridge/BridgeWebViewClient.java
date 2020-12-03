package com.fcbox.lib.fcjsbridge;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BridgeWebViewClient extends WebViewClient {

  private JSBridge jsBridge;

  public BridgeWebViewClient(JSBridge jsBridge) {
    this.jsBridge = jsBridge;
  }

  @Override
  public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (url.startsWith(BridgeUtil.BRIDGE_SCHEME)) {
      Log.e("BridgeWebView", "url == " + url);

      String moduleName = BridgeUtil.getModuleNameFromUrl(url);
      String id = BridgeUtil.getParamDataFromUrl(url);

      jsBridge.getParamsFromWeb(moduleName, id);
      return true;
    }
    return super.shouldOverrideUrlLoading(view, url);
  }

  @Override
  public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    String url = request.getUrl().toString();
    if (url.startsWith(BridgeUtil.BRIDGE_SCHEME)) {
      Log.e("BridgeWebView", "url == " + url);

      String moduleName = BridgeUtil.getModuleNameFromUrl(url);
      String id = BridgeUtil.getParamDataFromUrl(url);

      jsBridge.getParamsFromWeb(moduleName, id);
      return true;
    }
    return super.shouldOverrideUrlLoading(view, request);
  }
}
