package tddmicroexercises.tirepressuremonitoringsystem.sensor;

import tddmicroexercises.tirepressuremonitoringsystem.sensor.legacy.Sensor;

import java.util.Random;

public class SensorWetTire extends Sensor implements TelemeterySensor
{
    public final double OFFSET = 14;

    private static double samplePressure()
    {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 10 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
