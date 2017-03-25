package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.sensor.TelemeterySensor;

public class AlarmWetTire
{
    private TelemeterySensor sensor;
    private SafetyRangeWetTire safetyRange;

    private boolean alarmOn = false;

    public AlarmWetTire(TelemeterySensor sensor, SafetyRangeWetTire safetyRange) {

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
