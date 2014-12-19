package de.bischinger.tinkerforge.fluent;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class Sensors {

  public static TemperaturBuilder temperature(String uid) {
	return new TemperaturBuilder().uid(uid);
  }

  public static AmbientLightBuilder ambientLight(String uid) {
	return new AmbientLightBuilder().uid(uid);
  }

  public static BarometerBuilder barometer(String uid) {
	return new BarometerBuilder().uid(uid);
  }

  public static HumidityBuilder humidity(String uid) {
	return new HumidityBuilder().uid(uid);
  }
}
