package tddmicroexcersises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.AlarmNormalTire;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRangeNormalTire;
import tddmicroexercises.tirepressuremonitoringsystem.legacy.Sensor;

/**
 * Created by pj on 24/03/2017.
 */
class AlarmBuilderNormalTire {
    private Sensor sensor;
    private SafetyRangeNormalTire safetyRange;

    public static AlarmBuilderNormalTire anAlarm() {
        return new AlarmBuilderNormalTire();
    }

    public AlarmBuilderNormalTire usingSensor(Sensor sensor) {
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
