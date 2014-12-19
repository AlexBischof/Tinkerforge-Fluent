package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.BrickletHumidity;
import com.tinkerforge.BrickletTemperature;
import com.tinkerforge.Device;
import de.bischinger.tinkerforge.fluent.data.Callback;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class HumidityBuilder extends AbstractSensorBuilder<HumidityBuilder> {

  static HumidityBuilder temperature(String uid) {
	return new HumidityBuilder().uid(uid);
  }

  public HumidityBuilder analogValueListener(BrickletHumidity.AnalogValueListener listener, long period) {
	this.callbacks.add(new Callback(BrickletHumidity.AnalogValueListener.class, listener, period));
	return this;
  }

  public HumidityBuilder humidityListener(BrickletHumidity.HumidityListener listener, long period) {
	this.callbacks.add(new Callback(BrickletHumidity.HumidityListener.class, listener, period));
	return this;
  }

  @Override
  public Class<? extends Device> getDeviceClass() {
	return BrickletHumidity.class;
  }
}
