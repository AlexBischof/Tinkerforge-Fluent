package de.bischinger.tinkerforge.fluent;

import com.tinkerforge.BrickletSegmentDisplay4x7;
import com.tinkerforge.BrickletTemperature;
import com.tinkerforge.IPConnection;
import de.bischinger.tinkerforge.fluent.data.Bricklet;

public class ExampleCallback {
    private static final String HOST = "localhost";
    private static final int PORT = 4223;
    private static final String UID_TEMPERATUR = "dXj";
    private static final String UID_SEGMENT = "iW3";

    // Note: To make the example code cleaner we do not handle exceptions. Exceptions you
    //       might normally want to catch are described in the documentation
    public static void main(String args[]) throws Exception {
      BrickletReader brickletReader = new BrickletReader();
      brickletReader.readBricklets(HOST,PORT);
      Bricklet segmentId = brickletReader.getBrickletByDeviceId(BrickletSegmentDisplay4x7.DEVICE_IDENTIFIER);
      System.out.println(segmentId);

      IPConnection ipcon = new IPConnection(); // Create IP connection
        BrickletTemperature temp = new BrickletTemperature(UID_TEMPERATUR, ipcon); // Create device object
      final BrickletSegmentDisplay4x7 segmentDisplay4x7= new BrickletSegmentDisplay4x7(segmentId.getUid(),ipcon);
      short[] s = new short[]{character('e'), character('s'), character('e'), character('l')};
		segmentDisplay4x7.setSegments(s, (short) 5, false);

        ipcon.connect(HOST, PORT);

        /*temp.setTemperatureCallbackPeriod(1000);
        temp.addTemperatureListener(new BrickletTemperature.TemperatureListener() {
            public void temperature(short temperature) {
              int betterTemperature = temperature/100;
                System.out.println("Temperature: " + betterTemperature + " °C");

              int ziffer1 = temperature / 1000;
              int ziffer10 = temperature / 100;
              int ziffer100 = temperature / 10;
              int ziffer1000 = temperature % 10;

              System.out.println(ziffer1 + " " + ziffer10 + " " + ziffer100 + " " + ziffer1000);

              try {
	            short[] segments = {
			            character(Character.forDigit(ziffer1, 10)),
			            character(Character.forDigit(ziffer10, 10)),
			            character(Character.forDigit(ziffer100, 10)),
			            character(Character.forDigit(ziffer1000, 10))
	            };
                segmentDisplay4x7.setSegments(segments, (short) 5, false);
              } catch (Exception e) {
	            e.printStackTrace();
              }
            }
        });
        */

        System.out.println("Press key to exit"); System.in.read();
        ipcon.disconnect();
    }

  private static short character(char c) {
	switch (c) {
	//Zahlen
	case '0':
	  return 0x3f;
	case '1':
	  return 0x06;
	case '2':
	  return 0x5b;
	case '3':
	  return 0x4f;
	case '4':
	  return 0x66;
	case '5':
	  return 0x6d;
	case '6':
	  return 0x7d;
	case '7':
	  return 0x07;
	case '8':
	  return 0x7f;
	case '9':
	  return 0x6f;

	//Kleinbuchstaben
	case 'a':
	  return 0x5f;
	case 'b':
	  return 0x7c;
	case 'c':
	  return 0x58;
	case 'd':
	  return 0x5e;
	case 'e':
	  return 0x7b;
	case 'f':
	  return 0x71;
	case 'g':
	  return 0x6f;
	case 'h':
	  return 0x74;
	case 'i':
	  return 0x02;
	case 'j':
	  return 0x1e;
	case 'k':
	  return 0x00; //npr
	case 'l':
	  return 0x06;
	case 'm':
	  return 0x00; //npr
	case 'n':
	  return 0x54;
	case 'o':
	  return 0x5c;
	case 'p':
	  return 0x73;
	case 'q':
	  return 0x67;
	case 'r':
	  return 0x50;
	case 's':
	  return 0x6d;
	case 't':
	  return 0x78;
	case 'u':
	  return 0x1c;
	case 'v':
	  return 0x00;//npr
	case 'w':
	  return 0x00;//npr
	case 'x':
	  return 0x00;//npr
	case 'y':
	  return 0x6e;
	case 'z':
	  return 0x00;//npr

	//Großbuchstaben
	case 'A':
	  return 0x77;
	case 'B':
	  return 0x7c;
	case 'C':
	  return 0x39;
	case 'D':
	  return 0x5e;
	case 'E':
	  return 0x79;
	case 'F':
	  return 0x71;
	case 'G':
	  return 0x6f;
	case 'H':
	  return 0x76;
	case 'I':
	  return 0x06;
	case 'J':
	  return 0x1e;
	case 'K':
	  return 0x00; //npr
	case 'L':
	  return 0x38;
	case 'M':
	  return 0x00; //npr
	case 'N':
	  return 0x54;
	case 'O':
	  return 0x3f;
	case 'P':
	  return 0x73;
	case 'Q':
	  return 0x67;
	case 'R':
	  return 0x50;
	case 'S':
	  return 0x6d;
	case 'T':
	  return 0x78;
	case 'U':
	  return 0x3e;
	case 'V':
	  return 0x00;//npr
	case 'W':
	  return 0x00;//npr
	case 'X':
	  return 0x00;//npr
	case 'Y':
	  return 0x6e;
	case 'Z':
	  return 0x00;//npr
	}
	return 0;
  }
}