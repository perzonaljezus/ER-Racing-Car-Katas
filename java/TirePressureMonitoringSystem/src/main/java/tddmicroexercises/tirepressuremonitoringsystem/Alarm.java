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

        if (isNotInSafetyRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    private boolean isNotInSafetyRange(double psiPressureValue) {
        return psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue;
    }

    public double probeValue() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}
