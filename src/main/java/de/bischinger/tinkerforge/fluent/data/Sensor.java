package de.bischinger.tinkerforge.fluent.data;

import com.tinkerforge.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class Sensor<T extends Device> {
  private final String uid;
  private List<Callback> callbacks = new ArrayList<>();
  private T device;
  private Class<T> deviceClass;

  public Sensor(String uid) {
	this.uid = uid;
  }

  public void addCallback(Callback callback){
    this.callbacks.add(callback);
  }

  public String getUid() {
	return uid;
  }

  public List<Callback> getCallbacks() {
	return callbacks;
  }

  public T getDevice() {
	return device;
  }

  public Class<T> getDeviceClass() {
	return deviceClass;
  }

  public void setDevice(T device) {
	this.device = device;
  }

  public void setDeviceClass(Class<T> deviceClass) {
	this.deviceClass = deviceClass;
  }
}
