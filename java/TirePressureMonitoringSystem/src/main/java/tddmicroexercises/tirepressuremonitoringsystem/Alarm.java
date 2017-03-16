package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{

    private final SafetyRange safetyRange;
    private Sensor sensor;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.safetyRange = new SafetyRange(SafetyRange.lowPressureThreshold, SafetyRange.highPressureThreshold);
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (! safetyRange.isInSafetyRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
