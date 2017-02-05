package tddmicroexercises.tirepressuremonitoringsystem;

class Alarm
{
    public static final double lowPressureThreshold = 17;
    public static final double highPressureThreshold = 21;
    private final SafetyRange safetyRange;
    private final ISensor sensor;

    private boolean alarmOn;

    public Alarm(ISensor sensor, SafetyRange safetyRange) {
        this.sensor = sensor;
        this.alarmOn = false;
        this.safetyRange = safetyRange;
    }

    public void check()
    {
        double psiSamplePressure = sensor.probe();

        if (!safetyRange.isInSafetyRange(psiSamplePressure))
        {
            alarmOn = true;
        }
    }


    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}
