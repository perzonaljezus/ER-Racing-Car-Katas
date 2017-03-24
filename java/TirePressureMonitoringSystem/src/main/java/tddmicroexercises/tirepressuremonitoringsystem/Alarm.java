package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private Sensor sensor;
    private SafetyRange safetyRange;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor, SafetyRange safetyRange) {

        this.sensor = sensor;
        this.safetyRange = safetyRange;
    }

    public Alarm() {
        this.safetyRange = new SafetyRange(17. , 21. );
    }

    public void check()
    {
        double psiPressureValue = pressureValue();

        if (psiPressureValue < safetyRange.getLowPressureThreshold() || safetyRange.getHighPressureThreshold() < psiPressureValue)
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
