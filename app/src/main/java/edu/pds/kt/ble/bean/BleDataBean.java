package edu.pds.kt.ble.bean;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Administrator
 */
public class BleDataBean implements Serializable {
    private static final long serialVersionUID = 3942862920612792824L;

    public String deviceAddress;
    public UUID uuid;
    public byte[] buffer;
    public String time;
    public String name;
    public int Rssi;
    public String bleType;


    public BleDataBean(String deviceAddress, UUID uuid, String name,int rssi,String bleType,byte[] buffer) {
        this.deviceAddress = deviceAddress;
        this.uuid = uuid;
        this.buffer = buffer;
        this.name = name;
        this.Rssi = rssi;
        this.bleType = bleType;
    }
}
