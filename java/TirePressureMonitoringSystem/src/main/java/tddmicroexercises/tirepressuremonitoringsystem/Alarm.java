package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    public static final double lowPressureThreshold = 17;
    public static final double highPressureThreshold = 21;

    private Sensor sensor = new Sensor();

    private boolean alarmOn = false;

    public void check()
    {
        double psiSamplePressure = probePressure();

        if (!isInSafetyRange(psiSamplePressure))
        {
            alarmOn = true;
        }
    }

    private boolean isInSafetyRange(double samplePressure) {
        return (lowPressureThreshold <= samplePressure) && (samplePressure <= highPressureThreshold);
    }

    public double probePressure() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}
