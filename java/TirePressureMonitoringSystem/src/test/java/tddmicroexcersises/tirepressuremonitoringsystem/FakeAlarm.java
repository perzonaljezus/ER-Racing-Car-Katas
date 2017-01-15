package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

/**
 * Created by pj on 15/01/17.
 */
public class FakeAlarm extends Alarm {
    private double pressureValue;

    public FakeAlarm(double samplePressure) {
        super();

        this.pressureValue = samplePressure;
    }

    public double probePressure() {
        return pressureValue;
    }
}
