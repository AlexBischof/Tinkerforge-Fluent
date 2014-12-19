package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.Device;
import de.bischinger.tinkerforge.fluent.data.Callback;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class AmbientLightBuilder extends AbstractSensorBuilder<AmbientLightBuilder> {

  static AmbientLightBuilder ambientLight(String uid) {
	return new AmbientLightBuilder().uid(uid);
  }

  public AmbientLightBuilder analogListener(BrickletAmbientLight.AnalogValueListener listener, long period) {
	this.callbacks.add(new Callback(BrickletAmbientLight.AnalogValueListener.class, listener, period));
	return this;
  }

  public AmbientLightBuilder illuminanceListener(BrickletAmbientLight.IlluminanceListener listener, long period) {
	this.callbacks.add(new Callback(BrickletAmbientLight.IlluminanceListener.class, listener, period));
	return this;
  }

  public AmbientLightBuilder illuminanceListener(BrickletAmbientLight.IlluminanceListener listener) {
	this.callbacks.add(new Callback(BrickletAmbientLight.IlluminanceListener.class, listener));
	return this;
  }

  @Override
  public Class<? extends Device> getDeviceClass() {
	return BrickletAmbientLight.class;
  }
}
