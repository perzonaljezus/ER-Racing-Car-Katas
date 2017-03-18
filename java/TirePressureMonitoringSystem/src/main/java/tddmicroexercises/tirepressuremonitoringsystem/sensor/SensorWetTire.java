package tddmicroexercises.tirepressuremonitoringsystem.sensor;

import tddmicroexercises.tirepressuremonitoringsystem.sensor.legacy.Sensor;

public class SensorWetTire extends Sensor implements ISensor {
    public static final double OFFSET = 15;

    public double popNextPressurePsiValue()
    {
        return super.popNextPressurePsiValue();
    }

}
