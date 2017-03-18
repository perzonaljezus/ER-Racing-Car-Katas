package tddmicroexercises.tirepressuremonitoringsystem.sensor;

import tddmicroexercises.tirepressuremonitoringsystem.sensor.legacy.Sensor;

import java.util.Random;

public class SensorNormalTire extends Sensor implements ISensor {
    @Override
    public double popNextPressurePsiValue()
    {
        return super.popNextPressurePsiValue();
    }

    private static double samplePressure()
    {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 10 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
