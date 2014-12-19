package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.Device;
import de.bischinger.tinkerforge.fluent.data.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public abstract class AbstractSensorBuilder<T extends AbstractSensorBuilder<T>> {
  private String uid;
  List<Callback> callbacks = new ArrayList<>();

  public T uid(String uid) {
	this.uid = uid;
	return (T) this;
  }

  public String getUid() {
	return uid;
  }

  public List<Callback> getCallbacks() {
	return callbacks;
  }

  public abstract Class<? extends Device> getDeviceClass();
}
