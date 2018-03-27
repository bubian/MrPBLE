/*
 * Copyright (c) 2017. xiaoyunfei
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package edu.pds.kt.ble.frag;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import edu.pds.kt.ble.R;
import edu.pds.kt.ble.adapter.BleDeviceAdapter;
import edu.pds.kt.ble.base.BaseFragment;
import edu.pds.kt.ble.bean.BleDataBean;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Administrator
 */
public class BondedDevicesFragment extends BaseFragment {

  @BindView(R.id.rl_bound_device)
  RecyclerView mRlBoundDevice;

  private BleDeviceAdapter mDeviceAdapter;
  private List<BleDataBean> mBleDataBeanList = new ArrayList<>();

  @Override
  protected int getLayoutId() {
    return R.layout.ble_frag_device_list;
  }

  @Override
  protected void initComponent(Bundle savedInstanceState) {
    mDeviceAdapter = new BleDeviceAdapter(mContext,mBleDataBeanList);
  }

  @Override
  protected void initViews(View root) {
    mRlBoundDevice.setLayoutManager(new LinearLayoutManager(mContext));
    mRlBoundDevice.setAdapter(mDeviceAdapter);
  }
}
