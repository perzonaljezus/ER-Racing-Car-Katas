package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private static final String DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";

    private final MockTelemetryClient telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls()
    {
        telemetryClient = new MockTelemetryClient();
    }

    public String getDiagnosticInfo()
    {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo)
    {
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0)
        {
            telemetryClient.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
            retryLeft -= 1;
        }

        if (!telemetryClient.getOnlineStatus())
        {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }

    private class MockTelemetryClient extends TelemetryClient {

        private boolean onlineStatus;

        @Override
        public boolean getOnlineStatus() {
            return onlineStatus;
        }

        @Override
        public void connect(String telemetryServerConnectionString) {
            if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
            {
                throw new IllegalArgumentException();
            }

            onlineStatus = true; // always success
        }

    }
}
