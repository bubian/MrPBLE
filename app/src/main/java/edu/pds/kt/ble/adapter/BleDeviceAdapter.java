package edu.pds.kt.ble.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.pds.kt.ble.R;
import edu.pds.kt.ble.adapter.BleDeviceAdapter.DeviceHolder;
import edu.pds.kt.ble.bean.BleDataBean;
import java.util.List;

/**
 * @author Administrator
 */
public class BleDeviceAdapter extends RecyclerView.Adapter<DeviceHolder>{
  List<BleDataBean> mBeans;
  private Context mContext;
  private OnClickListener listener;

  public BleDeviceAdapter(Context context,List<BleDataBean> beans){
    mContext = context;
    mBeans = beans;
  }

  public void update(List<BleDataBean> beans){
    mBeans = beans;
    notifyDataSetChanged();
  }

  @Override
  public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new DeviceHolder(
        LayoutInflater.from(mContext).inflate(R.layout.ble_device_item,parent,false));
  }

  @Override
  public void onBindViewHolder(DeviceHolder holder, int position) {
    if (mBeans.size() <= position){
      return;
    }
    BleDataBean bean = mBeans.get(position);
    holder.bleName.setText(bean.name);
    holder.bleRssi.setText("Rssi: "+bean.Rssi);
    holder.bleType.setText(bean.bleType);
    holder.bleUUID.setText(bean.uuid.toString());

    holder.itemView.setTag(position);
    if (null != listener){
      holder.itemView.setOnClickListener(listener);
    }
  }

  @Override
  public int getItemCount() {
    return mBeans.size();
  }

  class DeviceHolder extends ViewHolder {

    TextView bleName;
    TextView bleRssi;
    TextView bleUUID;
    TextView bleType;

    DeviceHolder(View itemView) {
      super(itemView);
      bleType = itemView.findViewById(R.id.ble_type);
      bleUUID = itemView.findViewById(R.id.ble_device_uuid);
      bleRssi = itemView.findViewById(R.id.ble_rssi);
      bleName = itemView.findViewById(R.id.ble_device_name);
    }
  }

    public void setListener(OnClickListener listener){
      this.listener = listener;
    }

}
