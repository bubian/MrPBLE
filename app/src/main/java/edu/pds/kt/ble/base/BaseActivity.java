package edu.pds.kt.ble.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 * @author Administrator
 * @date 2018/3/27
 */

public class BaseActivity extends AppCompatActivity{

  protected Unbinder mUnbinder;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    initWindows();
    super.onCreate(savedInstanceState);
    int layoutId = getLayoutId();
    View layoutView = getContentView();
    if (layoutId > 0){
      setContentView(layoutId);
    }else if (null != layoutView){
      setContentView(layoutView);
    }else {
      mUnbinder = Unbinder.EMPTY;
    }
    mUnbinder = ButterKnife.bind(this);
    initComponent(savedInstanceState);
  }

  protected int getLayoutId(){
    return -1;
  }
  protected View getContentView(){
    return null;
  }
  protected void initWindows(){}
  protected void initComponent(Bundle savedInstanceState){}

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mUnbinder.unbind();
  }
}
