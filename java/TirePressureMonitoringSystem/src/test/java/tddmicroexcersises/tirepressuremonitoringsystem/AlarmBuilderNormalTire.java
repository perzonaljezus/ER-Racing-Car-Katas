package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.*;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.SensorNormalTire;

/**
 * Created by pj on 24/03/2017.
 */
class AlarmBuilderNormalTire {
    private SensorNormalTire sensor;
    private SafetyRangeNormalTire safetyRange;

    public static AlarmBuilderNormalTire anAlarm() {
        return new AlarmBuilderNormalTire();
    }

    public AlarmBuilderNormalTire usingSensor(SensorNormalTire sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilderNormalTire andWithSafetyRange(SafetyRangeNormalTire safetyRange) {
        this.safetyRange = safetyRange;
        return this;
    }

    public AlarmNormalTire build() {
        AlarmNormalTire alarm = new AlarmNormalTire(this.sensor, this.safetyRange);
        return alarm;
    }
}
