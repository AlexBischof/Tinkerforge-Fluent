package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.BrickletTemperature;
import com.tinkerforge.Device;
import de.bischinger.tinkerforge.fluent.data.Callback;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class TemperaturBuilder extends AbstractSensorBuilder<TemperaturBuilder> {

  static TemperaturBuilder temperature(String uid) {
	return new TemperaturBuilder().uid(uid);
  }

  public TemperaturBuilder temperaturListener(BrickletTemperature.TemperatureListener listener, long period) {
	this.callbacks.add(new Callback(BrickletTemperature.TemperatureListener.class, listener, period));
	return this;
  }

  @Override
  public Class<? extends Device> getDeviceClass() {
	return BrickletTemperature.class;
  }
}
