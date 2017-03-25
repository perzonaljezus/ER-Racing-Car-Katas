package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.legacy.Sensor;

import java.util.Random;

public class SensorWetTire extends Sensor
{
    public static final double OFFSET = 14;

    public double popNextPressurePsiValue()
    {
        double pressureTelemetryValue;
        pressureTelemetryValue = samplePressure();

        return OFFSET + pressureTelemetryValue;
    }

    private static double samplePressure()
    {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 10 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
