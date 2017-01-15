package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

/**
 * Created by pj on 14/01/17.
 */
class MockSensor extends Sensor {

    final double value;

    public MockSensor(double _value) {
        value = _value;
    }

    @Override
    public double popNextPressurePsiValue() {
        return value;
    }

}
