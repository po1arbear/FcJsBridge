package com.fcbox.lib.fcjsbridge;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.fcbox.anglib.fcwebview.FcWebview;
import com.fcbox.anglib.fcwebview.base.IWebview;
import com.fcbox.anglib.fcwebview.base.WebViewClient;

public class MainActivity2 extends AppCompatActivity {

  @SuppressLint("SetJavaScriptEnabled")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    FcWebview mWebView = findViewById(R.id.web_view);

    mWebView.getFcWebviewSettings().setJavaScriptEnabled(true);

    final JSBridge jsBridge = new JSBridge(mWebView);

    mWebView.setWebViewClient(new WebViewClient() {

      @Override
      public boolean shouldOverrideUrlLoading(IWebview view, String url) {
        if (url.startsWith(BridgeUtil.BRIDGE_SCHEME)) {
          Log.e("BridgeWebView", "url == " + url);

          String moduleName = BridgeUtil.getModuleNameFromUrl(url);
          String id = BridgeUtil.getParamDataFromUrl(url);

          jsBridge.getParamsFromWeb(moduleName, id);
          return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
      }
    });

    mWebView.loadUrl("http://hybrid-app-sit2.fcbox.com");
  }
}