package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.AlarmWetTire;
import tddmicroexercises.tirepressuremonitoringsystem.safetyRange.SafetyRangeWetTire;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.TelemeterySensor;

/**
 * Created by pj on 24/03/2017.
 */
class AlarmBuilderWetTire {
    private TelemeterySensor sensor;
    private SafetyRangeWetTire safetyRange;

    public static AlarmBuilderWetTire anAlarm() {
        return new AlarmBuilderWetTire();
    }

    public AlarmBuilderWetTire usingSensor(TelemeterySensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilderWetTire andWithSafetyRange(SafetyRangeWetTire safetyRange) {
        this.safetyRange = safetyRange;
        return this;
    }

    public AlarmWetTire build() {
        AlarmWetTire alarm = new AlarmWetTire(this.sensor, this.safetyRange);
        return alarm;
    }
}
