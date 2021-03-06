import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.BrickletBarometer;
import com.tinkerforge.BrickletTemperature;
import com.tinkerforge.IPConnection;
import de.bischinger.tinkerforge.fluent.Tinkerforges;

import static de.bischinger.tinkerforge.fluent.Sensors.*;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class Test {
  public static void main(String[] args)
		  throws Exception {

    IPConnection ipcon = Tinkerforges.connectTo("localhost")
                                     .withSensor(temperature("dXj").temperaturListener(
		                                     e -> System.out.println("temperature: " + e)))
                                     .withSensor(ambientLight("jy2").illuminanceListener(
		                                     e -> System.out.println("ambientLight: " + e)))
                                     .withSensor(barometer("jY4").airPressureListener(
		                                     e -> System.out.println("airpressure: " + e)))
                                     .withSensor(humidity("kfd")
		                                                 .humidityListener(e -> System.out.println("humidity: " + e)))
                                     .build();

    System.out.println("Press key to exit");
    System.in.read();
    ipcon.disconnect();
  }
}
