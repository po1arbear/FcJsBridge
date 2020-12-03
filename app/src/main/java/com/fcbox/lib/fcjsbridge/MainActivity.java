package com.fcbox.lib.fcjsbridge;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BridgeWebView mWebView = findViewById(R.id.web_view);

    mWebView.setWebViewClient(new BridgeWebViewClient(new JSBridge(mWebView)));

    mWebView.loadUrl("http://hybrid-app-sit2.fcbox.com");
  }
}