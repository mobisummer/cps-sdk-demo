# MSCPS接入文档

### I.初始化

1. 在build.gralde(project)中添加

   ```groovy
   repositories { 
   	maven { url "https://raw.githubusercontent.com/mobisummer/cps-sdk/master" }
   }
   ```

2. 在build.gradle(module)中添加以下依赖

   ```groovy
   dependencies {
     implementation 'com.google.code.gson:gson:2.8.5'
     implementation "com.ms.mscps:sdk:1.0.3"
   }
   ```

3. 初始化SDK（请尽早初始化SDK）

   ```java
   AdSdk.start(context, "app_id");//app_id请联系商务获取
   ```

### II.横幅广告

1. 加载&展示广告

   ```java
   BannerAd mBannerAdView = new BannerAd(context);
   youLayout.addView(bannerAd);//在布局中添加view
   AdRequest request = AdRequest.newBuilder().pub("pid").build();//pid请联系商务获取
   bannerAd.loadAd(request);
   ```

2. 设置监听器（可选）

   ```java
   bannerAd.setAdListener(new AdListener() {
     @Override
     public void onAdError(Ad ad, int i, String s) {
          //广告加载出错
     }
     @Override
     public void onAdLoaded(Ad ad) {
          //广告加载完毕
     }
     @Override
     public void onAdShowed(Ad ad) {
          //广告展示
     }
     @Override
     public void onAdClosed(Ad ad) {
          //广告关闭
     }
     @Override
     public void onAdClicked(Ad ad) {
          //广告被点击
     }
   });
   ```

### III.插屏广告

1. 加载广告

   ```java
   InterstitialAd interstitialAd = new InterstitialAd();
   AdRequest request = AdRequest.newBuilder().pub("pid").build();//pid请联系商务获取
   interstitialAd.loadAd(request);
   ```

2. 展示广告

   ```java
   interstitialAd.showAd();//建议写在监听器的onAdLoaded中
   ```

3. 设置监听器（可选）

   ```java
   interstitialAd.setAdListener(new AdListener() {
     @Override
     public void onAdError(Ad ad, int i, String s) {
          //广告加载出错
     }
     @Override
     public void onAdLoaded(Ad ad) {
          //广告加载完毕
     }
     @Override
     public void onAdShowed(Ad ad) {
          //广告展示
     }
     @Override
     public void onAdClosed(Ad ad) {
          //广告关闭
     }
     @Override
     public void onAdClicked(Ad ad) {
          //广告被点击
     }
   });
   ```
