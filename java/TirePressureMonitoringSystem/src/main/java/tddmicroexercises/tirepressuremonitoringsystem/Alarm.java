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

        if (isNotInSafetyRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    protected boolean isNotInSafetyRange(double psiPressureValue) {
        return psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue;
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
