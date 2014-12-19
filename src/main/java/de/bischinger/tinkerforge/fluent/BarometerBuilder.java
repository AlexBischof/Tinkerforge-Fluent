package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.BrickletBarometer;
import com.tinkerforge.Device;
import de.bischinger.tinkerforge.fluent.data.Callback;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class BarometerBuilder extends AbstractSensorBuilder<BarometerBuilder> {

  static BarometerBuilder barometer(String uid) {
	return new BarometerBuilder().uid(uid);
  }

  public BarometerBuilder airPressureListener(BrickletBarometer.AirPressureListener listener, long period) {
	this.callbacks.add(new Callback(BrickletBarometer.AirPressureListener.class, listener, period));
	return this;
  }

  public BarometerBuilder airPressureListener(BrickletBarometer.AirPressureListener listener) {
	this.callbacks.add(new Callback(BrickletBarometer.AirPressureListener.class, listener));
	return this;
  }

  public BarometerBuilder altitudeListener(BrickletBarometer.AltitudeListener listener, long period) {
	this.callbacks.add(new Callback(BrickletBarometer.AltitudeListener.class, listener, period));
	return this;
  }

  public BarometerBuilder altitudeListener(BrickletBarometer.AltitudeListener listener) {
	this.callbacks.add(new Callback(BrickletBarometer.AltitudeListener.class, listener));
	return this;
  }

  @Override
  public Class<? extends Device> getDeviceClass() {
	return BrickletBarometer.class;
  }
}
