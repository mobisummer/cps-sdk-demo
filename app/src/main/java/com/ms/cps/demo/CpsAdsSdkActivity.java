package com.ms.cps.demo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class CpsAdsSdkActivity extends AppCompatActivity
    implements android.support.v7.app.ActionBar.TabListener {

  private ViewPager mViewPager;
  private MsFragmentPagerAdapter mViewPagerAdapter;
  private android.support.v7.app.ActionBar mActionBar;

  private String[] mTagNameArray = {
      "Banner", "Interstitial",
      };

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mViewPagerAdapter = new MsFragmentPagerAdapter(getSupportFragmentManager());

    mViewPager = new ViewPager(this);
    mViewPager.setId(R.id.main_view_pager);
    mViewPager.setAdapter(mViewPagerAdapter);
    mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
        mActionBar.setSelectedNavigationItem(position);
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });

    FrameLayout contentContainer = new FrameLayout(this);
    contentContainer.addView(mViewPager);

    setContentView(contentContainer,
                   new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                              ViewGroup.LayoutParams.MATCH_PARENT));

    mActionBar = getSupportActionBar();
    mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    for (String tabName : mTagNameArray) {
      mActionBar.addTab(mActionBar.newTab().setText(tabName).setTabListener(this));
    }
  }

  @Override
  public void onTabSelected(android.support.v7.app.ActionBar.Tab tab,
                            android.support.v4.app.FragmentTransaction ft) {
    mViewPager.setCurrentItem(tab.getPosition());
  }

  @Override
  public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab,
                              android.support.v4.app.FragmentTransaction ft) {

  }

  @Override
  public void onTabReselected(android.support.v7.app.ActionBar.Tab tab,
                              android.support.v4.app.FragmentTransaction ft) {

  }
}
