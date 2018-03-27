// Generated code from Butter Knife. Do not modify!
package edu.pds.kt.ble.frag;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import edu.pds.kt.ble.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DeviceScanFragment_ViewBinding implements Unbinder {
  private DeviceScanFragment target;

  @UiThread
  public DeviceScanFragment_ViewBinding(DeviceScanFragment target, View source) {
    this.target = target;

    target.mRlBoundDevice = Utils.findRequiredViewAsType(source, R.id.rl_bound_device, "field 'mRlBoundDevice'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DeviceScanFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRlBoundDevice = null;
  }
}
