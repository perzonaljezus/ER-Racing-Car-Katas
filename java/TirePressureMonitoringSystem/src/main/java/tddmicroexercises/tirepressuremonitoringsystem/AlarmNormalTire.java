package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.legacy.Sensor;
import tddmicroexercises.tirepressuremonitoringsystem.safetyRange.SafetyRangeNormalTire;

public class AlarmNormalTire
{
    private Sensor sensor;
    private SafetyRangeNormalTire safetyRange;

    private boolean alarmOn = false;

    public AlarmNormalTire(Sensor sensor, SafetyRangeNormalTire safetyRange) {

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
