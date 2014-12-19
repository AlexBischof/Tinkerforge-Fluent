package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.*;
import de.bischinger.tinkerforge.fluent.data.Callback;
import de.bischinger.tinkerforge.fluent.data.Sensor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class ConnectionBuilder {

  private final static String TRESHOLD = "Treshold";

  private String host = "127.0.0.1";
  private int port = 4223;
  private long defaultCallbackPeriod = 100;
  private String uid;

  private List<Sensor<?>> sensorList = new ArrayList<>();

  public ConnectionBuilder host(String host) {
	this.host = host;
	return this;
  }

  public ConnectionBuilder withPort(int port) {
	this.port = port;
	return this;
  }

  public ConnectionBuilder defaultCallbackPeriod(long defaultCallbackPeriod) {
	this.defaultCallbackPeriod = defaultCallbackPeriod;
	return this;
  }

  public ConnectionBuilder withSensor(AbstractSensorBuilder sensorbuilder) {
	Sensor sensor = new Sensor(sensorbuilder.getUid());
	sensor.setDeviceClass(sensorbuilder.getDeviceClass());
	List<Callback> callbacks = sensorbuilder.getCallbacks();
	callbacks.forEach(sensor::addCallback);
	sensorList.add(sensor);
	return this;
  }

  public ConnectionBuilder withUid(String uid) {
	this.uid = uid;
	return this;
  }

  public void build() throws AlreadyConnectedException, IOException, TimeoutException, NotConnectedException {
	IPConnection ipcon = new IPConnection(); // Create IP connection

	//Create Sensors
	for (Sensor sensor : sensorList) {
	  Class<Device> deviceClass = sensor.getDeviceClass();
	  Device device = null;
	  try {
		device = deviceClass.getConstructor(String.class, IPConnection.class).newInstance(sensor.getUid(), ipcon);
		sensor.setDevice(device);
	  } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
		e.printStackTrace();
	  }
	}

	//Connect
	ipcon.connect(host, port);

	//Callbacks aufrufen
	for (Sensor sensor : sensorList) {

	  Class deviceClass = sensor.getDeviceClass();

	  List<Callback> callbacks = sensor.getCallbacks();
	  for (Callback callback : callbacks) {

		//Gets listener class and uses reflection to invoke setXXXCallbackPeriod and addXXXListener
		Class<? extends DeviceListener> listenerClass = callback.getListenerClass();

		String callbackName = listenerClass.getSimpleName().replace("Listener", "");
		String callbackNameWithListener = listenerClass.getSimpleName();

		//Set callback period
		try {
		  //Use defaultCallback
		  long period = callback.getPeriod();
		  if (period == 0) {
			period = defaultCallbackPeriod;
		  }

		  Method callbackPeriodMethod = deviceClass
				  .getDeclaredMethod("set" + callbackName.replace("Period", TRESHOLD) + "CallbackPeriod", long.class);
		  callbackPeriodMethod.invoke(sensor.getDevice(), period);
		} catch (NoSuchMethodException e) {
		  e.printStackTrace();
		} catch (InvocationTargetException e) {
		  e.printStackTrace();
		} catch (IllegalAccessException e) {
		  e.printStackTrace();
		}

		//Set listener
		try {
		  Method listenerMethod = deviceClass
				  .getDeclaredMethod("add" + callbackNameWithListener, callback.getListenerClass());
		  listenerMethod.invoke(sensor.getDevice(), callback.getListener());
		} catch (NoSuchMethodException e) {
		  e.printStackTrace();
		} catch (InvocationTargetException e) {
		  e.printStackTrace();
		} catch (IllegalAccessException e) {
		  e.printStackTrace();
		}

	   /* BrickletTemperature device = (BrickletTemperature) sensor.getDevice();
		System.out.println("set callback period to " + callback.getPeriod());
		device.addTemperatureListener((BrickletTemperature.TemperatureListener) callback.getListener());
		*/
	  }
	}

	System.out.println("Press key to exit");
	System.in.read();
	ipcon.disconnect();
  }
}
