package tddmicroexercises.telemetrysystem;

/**
 * Created by pj on 11/02/17.
 */
class MockTelemetryClient extends TelemetryClient {

    private boolean onlineStatus;

    @Override
    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    @Override
    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw new IllegalArgumentException();
        }

        onlineStatus = true; // always success
    }

}
