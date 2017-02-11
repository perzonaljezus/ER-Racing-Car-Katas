package tddmicroexercises.telemetrysystem;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * TelemetryDiagnosticControls Tester.
 */
public class TelemetryDiagnosticControlsTest {

    private static TelemetryDiagnosticControls controls;

    @BeforeMethod
    public void setUp() throws Exception {
        controls = new TelemetryDiagnosticControls();
    }

    /**
     * Method: setDiagnosticInfo()
     */
    @Test
    public void testSetDiagnosticInfo() throws Exception {
        // Setup Test
        String message = "LAST TX rate................ 100 MBPS\r\n" //
                + "HIGHEST TX rate............. 100 MBPS\r\n" //
                + "LAST RX rate................ 100 MBPS\r\n" //
                + "HIGHEST RX rate............. 100 MBPS\r\n" //
                + "BIT RATE.................... 100000000\r\n" //
                + "WORD LEN.................... 16\r\n" //
                + "WORD/FRAME.................. 511\r\n" //
                + "BITS/FRAME.................. 8192\r\n" //
                + "MODULATION TYPE............. PCM/FM\r\n" //
                + "TX Digital Los.............. 0.75\r\n" //
                + "RX Digital Los.............. 0.10\r\n" //
                + "BEP Test.................... -5\r\n" //
                + "Local Rtrn Count............ 00\r\n" //
                + "Remote Rtrn Count........... 00";
        controls.setDiagnosticInfo(message);

        // Test
        String actual = controls.getDiagnosticInfo();
        String expected = "LAST TX rate................ 100 MBPS\r\n" //
                + "HIGHEST TX rate............. 100 MBPS\r\n" //
                + "LAST RX rate................ 100 MBPS\r\n" //
                + "HIGHEST RX rate............. 100 MBPS\r\n" //
                + "BIT RATE.................... 100000000\r\n" //
                + "WORD LEN.................... 16\r\n" //
                + "WORD/FRAME.................. 511\r\n" //
                + "BITS/FRAME.................. 8192\r\n" //
                + "MODULATION TYPE............. PCM/FM\r\n" //
                + "TX Digital Los.............. 0.75\r\n" //
                + "RX Digital Los.............. 0.10\r\n" //
                + "BEP Test.................... -5\r\n" //
                + "Local Rtrn Count............ 00\r\n" //
                + "Remote Rtrn Count........... 00";
        assertEquals(expected, actual);
    }

    /**
     * Method: getDiagnosticInfo(String diagnosticInfo)
     */
    @Test
    public void testgetDiagnosticInfo() throws Exception {
        String expected = "";
        String actual = controls.getDiagnosticInfo();
        assertEquals(expected, actual);
    }

    /**
     * Method: checkTransmission()
     */
    @Test
    public void testCheckTransmission() throws Exception {
        String expected = "LAST TX rate................ 100 MBPS\r\n" //
                + "HIGHEST TX rate............. 100 MBPS\r\n" //
                + "LAST RX rate................ 100 MBPS\r\n" //
                + "HIGHEST RX rate............. 100 MBPS\r\n" //
                + "BIT RATE.................... 100000000\r\n" //
                + "WORD LEN.................... 16\r\n" //
                + "WORD/FRAME.................. 511\r\n" //
                + "BITS/FRAME.................. 8192\r\n" //
                + "MODULATION TYPE............. PCM/FM\r\n" //
                + "TX Digital Los.............. 0.75\r\n" //
                + "RX Digital Los.............. 0.10\r\n" //
                + "BEP Test.................... -5\r\n" //
                + "Local Rtrn Count............ 00\r\n" //
                + "Remote Rtrn Count........... 00";

        controls.checkTransmission();
        String actual = controls.getDiagnosticInfo();
        assertEquals(expected, actual);
    }


} 
