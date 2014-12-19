package de.bischinger.tinkerforge.fluent;

/**
 * Created by Alexander Bischof on 16.12.14.
 */
public class Tinkerforges {

  public static ConnectionBuilder connectTo(String host) {
    ConnectionBuilder connectionBuilder = new ConnectionBuilder();
    connectionBuilder.host(host);
    return connectionBuilder;
  }

  public static ConnectionBuilder withUid(String uid) {
    ConnectionBuilder connectionBuilder = new ConnectionBuilder();
    connectionBuilder.withUid(uid);
    return connectionBuilder;
  }
}
