import de.bischinger.tinkerforge.fluent.Tinkerforges;

import static de.bischinger.tinkerforge.fluent.Sensors.*;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class Test {
  public static void main(String[] args)
		  throws Exception {

	Tinkerforges.connectTo("localhost")
	            .withSensor(temperature("dXj").temperaturListener(e -> System.out.println("temperature: " + e), 100))
	            .withSensor(ambientLight("jy2").illuminanceListener(e -> System.out.println("ambientLight: " + e), 100))
	            .withSensor(barometer("jY4").airPressureListener(e -> System.out.println("airpressure: " + e), 100))
	            .withSensor(humidity("kfd").humidityListener(e -> System.out.println("humidity: " + e), 100))
	            .build();
  }
}
