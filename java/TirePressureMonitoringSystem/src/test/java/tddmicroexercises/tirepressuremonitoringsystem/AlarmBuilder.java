package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 05/02/17.
 */
public class AlarmBuilder {
    protected ISensor sensor;
    protected SafetyRange safetyRange;

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder usingSensor(SensorThatProbes sensor) {
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
