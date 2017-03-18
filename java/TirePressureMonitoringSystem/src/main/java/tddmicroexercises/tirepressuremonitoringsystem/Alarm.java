package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.safetyrange.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.ISensor;

public class Alarm
{
    private ISensor sensor;
    private SafetyRange safetyRange;

    private boolean alarmOn = false;

    public Alarm(ISensor sensor, SafetyRange safetyRange) {
        this.sensor = sensor;
        this.safetyRange = safetyRange;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < safetyRange.lowThreshold() || safetyRange.highThreshold() < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}
