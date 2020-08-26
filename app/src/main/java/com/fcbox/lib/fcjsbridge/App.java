package com.fcbox.lib.fcjsbridge;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建者 003099
 * @创建时间 2020/7/3 17:07
 * @描述
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Map<String, BaseJSPlugin> map = new HashMap<>();
        map.put(JSUiTitlePlugin.UI_NAV_SET_TITLE, new JSUiTitlePlugin());
        map.put(JSCommPlugin.COMMON_1, new JSCommPlugin());
        map.put(JSCommPlugin.COMMON_2, new JSCommPlugin());
        map.put(JSCommPlugin.COMMON_3, new JSCommPlugin());
        PluginManager.INSTANCE.registerJSPlugin(map);
    }
}
