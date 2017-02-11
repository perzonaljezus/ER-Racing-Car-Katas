package tddmicroexercises.telemetrysystem;

/**
 * Created by pj on 11/02/17.
 */
public interface ITelemetryClient {
    boolean getOnlineStatus();

    void connect(String telemetryServerConnectionString);

    public void disconnect();

    public void send(String message);

    public String receive();

}
