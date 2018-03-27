// Generated code from Butter Knife. Do not modify!
package edu.pds.kt.ble;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mTabLayout = Utils.findRequiredViewAsType(source, R.id.tabLayout, "field 'mTabLayout'", TabLayout.class);
    target.mContainerLayout = Utils.findRequiredViewAsType(source, R.id.containerLayout, "field 'mContainerLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTabLayout = null;
    target.mContainerLayout = null;
  }
}
