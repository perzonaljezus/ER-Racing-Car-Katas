package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static final double lowPressureThreshold = 17;
    public static final double highPressureThreshold = 21;
    private final SafetyRange safetyRange;
    private final Sensor sensor;

    private boolean alarmOn;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.alarmOn = false;
        this.safetyRange = new SafetyRange(lowPressureThreshold, highPressureThreshold);
    }

    public void check()
    {
        double psiSamplePressure = probePressure();

        if (!safetyRange.isInSafetyRange(psiSamplePressure))
        {
            alarmOn = true;
        }
    }


    private double probePressure() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}
