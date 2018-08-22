package com.ms.cps.demo;

import android.app.Application;

import com.ms.cps.sdk.AdSdk;


public class CpsAdsDemoApp extends Application {
  private final static String TAG = CpsAdsDemoApp.class.getSimpleName();

  @Override
  public void onCreate() {
    super.onCreate();
    AdSdk.start(this, "cpstest@cpssdk");
  }


}
