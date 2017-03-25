package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.safetyRange.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.TelemeterySensor;

/**
 * Created by pj on 24/03/2017.
 */
class AlarmBuilder {
    private TelemeterySensor sensor;
    private SafetyRange safetyRange;

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder usingSensor(TelemeterySensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilder andWithSafetyRange(SafetyRange safetyRange) {
        this.safetyRange = safetyRange;
        return this;
    }

    public Alarm build() {
        Alarm alarm = new Alarm(this.sensor, this.safetyRange);
        return alarm;
    }
}
