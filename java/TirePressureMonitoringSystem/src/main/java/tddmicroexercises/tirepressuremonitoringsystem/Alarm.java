package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.safetyRange.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.TelemeterySensor;

public class Alarm
{
    private TelemeterySensor sensor;
    private SafetyRange safetyRange;

    private boolean alarmOn = false;

    public Alarm(TelemeterySensor sensor, SafetyRange safetyRange) {

        this.sensor = sensor;
        this.safetyRange = safetyRange;
    }

    public void check()
    {
        double psiPressureValue = pressureValue();

        if (!isInSafetyRange(psiPressureValue))
        {
            alarmOn = true;
        }
    }

    protected boolean isInSafetyRange(double psiPressureValue) {
        return psiPressureValue >= safetyRange.getLowPressureThreshold() && safetyRange.getHighPressureThreshold() >= psiPressureValue;
    }

    protected double pressureValue() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
