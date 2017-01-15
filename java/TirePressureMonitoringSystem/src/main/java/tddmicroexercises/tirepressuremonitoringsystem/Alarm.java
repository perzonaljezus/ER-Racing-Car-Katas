package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static final double lowPressureThreshold = 17;
    public static final double highPressureThreshold = 21;

    private Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public void check()
    {
        double psiPressureValue = probeValue();

        if (!isInSafetyRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    private boolean isInSafetyRange(double psiPressureValue) {
        return (lowPressureThreshold <= psiPressureValue) && (psiPressureValue <= highPressureThreshold);
    }

    public double probeValue() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}
