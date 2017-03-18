package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private SafetyRange safetyRange;
    private ISensor sensor;

    private boolean alarmOn = false;

    public Alarm(ISensor sensor, SafetyRange safetyRange) {

        this.sensor = sensor;
        this.safetyRange = safetyRange;
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
