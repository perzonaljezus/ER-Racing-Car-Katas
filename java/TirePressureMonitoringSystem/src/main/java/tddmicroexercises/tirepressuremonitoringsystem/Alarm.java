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

        if (! isInSafetyRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    protected boolean isInSafetyRange(double psiPressureValue) {
        return SafetyRange.lowPressureThreshold <= psiPressureValue && psiPressureValue <= SafetyRange.highPressureThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
