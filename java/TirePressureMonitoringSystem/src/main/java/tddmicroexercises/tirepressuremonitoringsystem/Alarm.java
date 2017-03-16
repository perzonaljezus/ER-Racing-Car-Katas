package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static double lowPressureThreshold = 17;
    public static double highPressureThreshold = 21;

    private Sensor sensor;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
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
        return lowPressureThreshold <= psiPressureValue && psiPressureValue <= highPressureThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
