package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.safetyrange.SafetyRangeNormalTire;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.ISensor;

/**
 * Created by pj on 18/03/2017.
 */
public class AlarmBuilder {

    private ISensor sensor;
    private SafetyRangeNormalTire safetyRange;

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder usingSensor(ISensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilder andWithSafetyRange(SafetyRange safetyRange) {
        this.safetyRange = safetyRange;
        return this;
    }

    public Alarm build() {
        return new Alarm(sensor, safetyRange);
    }
}
