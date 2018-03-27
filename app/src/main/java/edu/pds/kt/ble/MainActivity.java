package edu.pds.kt.ble;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import butterknife.BindView;
import edu.pds.kt.ble.base.BaseActivity;
import edu.pds.kt.ble.frag.BondedDevicesFragment;
import edu.pds.kt.ble.frag.DeviceScanFragment;

/**
 * @author Administrator
 */


public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";
  @BindView(R.id.tabLayout)
  TabLayout mTabLayout;

  @BindView(R.id.containerLayout)
  FrameLayout mContainerLayout;

  private ActionBar mActionBar;
  private FragmentManager mFragmentManager;
  private FragmentTransaction mTransaction;
  /**
   * 扫描到的新蓝牙设备
   */
  private DeviceScanFragment mScanFragment;
  /**
   * 已经配对的蓝牙设备
   */
  private BondedDevicesFragment mDevicesFragment;

  private MenuItem menuRefresh;
  private MenuItem menuScan;

  private int currentIndex = 0;

  @Override
  protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void initComponent(Bundle savedInstanceState) {
    mActionBar = getSupportActionBar();
    if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP && null != mActionBar) {
      mActionBar.setElevation(0);
    }

    mScanFragment = new DeviceScanFragment();
    mDevicesFragment = new BondedDevicesFragment();

    mFragmentManager = getFragmentManager();
    mTransaction = mFragmentManager.beginTransaction();
    mTransaction.add(R.id.containerLayout, mScanFragment);
    mTransaction.commit();

    mTabLayout.addTab(mTabLayout.newTab().setText("扫描蓝牙"), true);
    mTabLayout.addTab(mTabLayout.newTab().setText("配对蓝牙"));

    mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        onTabChanged(tab);
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });
  }

  private void onTabChanged(TabLayout.Tab tab) {
    currentIndex = tab.getPosition();
    mTransaction = mFragmentManager.beginTransaction();

    reSetMenu();

    if (currentIndex == 0) {
      mTransaction.replace(R.id.containerLayout, mScanFragment);
    } else if (currentIndex == 1) {
      mTransaction.replace(R.id.containerLayout, mDevicesFragment);
      menuScan.setVisible(false);
    }
    mTransaction.commit();
  }

  public void reSetMenu() {
    if (menuRefresh == null) {
      return;
    }
    menuRefresh.setVisible(false);
    menuRefresh.setActionView(null);
    menuScan.setTitle("Scan");
    menuScan.setVisible(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);

    menuRefresh = menu.findItem(R.id.menu_refresh);
    menuScan = menu.findItem(R.id.menu_scan);

    reSetMenu();
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      startToSetting();
      return true;
    }

    if (id == R.id.action_about) {
      startToAbout();
      return true;
    }
    if (id == R.id.menu_scan) {
      if (menuRefresh.isVisible()) {

        reSetMenu();
      } else {

        menuRefresh.setVisible(true);

        menuScan.setTitle("Scanning");
      }
    }
    return super.onOptionsItemSelected(item);
  }

  private void startToSetting() {
    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
    startActivity(intent);
  }

  private void startToAbout() {
    Intent intent = new Intent(MainActivity.this, AboutActivity.class);
    startActivity(intent);
  }

  @Override
  protected void onPause() {
    super.onPause();
    reSetMenu();
  }
}
