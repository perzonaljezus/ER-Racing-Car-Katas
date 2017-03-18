package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 18/03/2017.
 */
public class AlarmBuilder {

    private Sensor sensor;
    private SafetyRange safetyRange;

    public static AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    public AlarmBuilder usingSensor(Sensor sensor) {
        this.sensor = sensor;
        return this;
    }

    public AlarmBuilder andWithSafetyRange(SafetyRange safetyRange) {
        this.safetyRange = safetyRange;
        return this;
    }

}
