package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 05/02/17.
 */
public class AlarmBuilder {
    protected ISensor sensor;
    protected SafetyRange safetyRange;

    public AlarmBuilder usingSensor(SensorThatProbes sensor) {
        this.sensor = sensor;
        return this;
    }

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }
}
