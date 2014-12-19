package de.bischinger.tinkerforge.fluent.data;

import com.tinkerforge.DeviceListener;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class Callback {
  private long period;
  private final DeviceListener listener;
  private final Class<? extends DeviceListener> listenerClass;

  public Callback(Class<? extends DeviceListener> listenerClass, DeviceListener listener) {
	this(listenerClass, listener, 0);
  }

  public Callback(Class<? extends DeviceListener> listenerClass, DeviceListener listener, long period) {
	this.listenerClass = listenerClass;
	this.listener = listener;
	this.period = period;
  }

  public long getPeriod() {
	return period;
  }

  public DeviceListener getListener() {
	return listener;
  }

  public Class<? extends DeviceListener> getListenerClass() {
	return listenerClass;
  }
}
