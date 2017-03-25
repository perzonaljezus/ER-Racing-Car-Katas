package tddmicroexercises.tirepressuremonitoringsystem;

public class AlarmWetTire
{
    private SensorWetTire sensor;
    private SafetyRangeWetTire safetyRange;

    private boolean alarmOn = false;

    public AlarmWetTire(SensorWetTire sensor, SafetyRangeWetTire safetyRange) {

        this.sensor = sensor;
        this.safetyRange = safetyRange;
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
