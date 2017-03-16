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
        double psiPressureValue = pressureValue();

        if (psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    protected double pressureValue() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
