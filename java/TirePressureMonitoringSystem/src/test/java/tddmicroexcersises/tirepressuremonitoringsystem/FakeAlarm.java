package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

/**
 * Created by pj on 15/01/17.
 */
public class FakeAlarm extends Alarm {
    private double pressureValue;

    public FakeAlarm(double pressureValue) {
        super();

        this.pressureValue = pressureValue;
    }

    public double probeValue() {
        return pressureValue;
    }
}
