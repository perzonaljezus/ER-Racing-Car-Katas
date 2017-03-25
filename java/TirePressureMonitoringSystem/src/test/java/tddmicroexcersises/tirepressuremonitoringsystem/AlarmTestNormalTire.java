package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.safetyRange.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.safetyRange.SafetyRangeNormalTire;
import tddmicroexercises.tirepressuremonitoringsystem.sensor.TelemeterySensor;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;
import static tddmicroexcersises.tirepressuremonitoringsystem.AlarmBuilder.anAlarm;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTestNormalTire {
    @Mock
    private TelemeterySensor sensor;
    private SafetyRange safetyRange;
    private Alarm alarm;



    @Before
    public void setup() {
        this.safetyRange = new SafetyRangeNormalTire();
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOk() {
        given(sensor.popNextPressurePsiValue()).willReturn((safetyRange.getHighPressureThreshold() + safetyRange.getLowPressureThreshold()) /2);
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getHighPressureThreshold() +1);
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getLowPressureThreshold() -1);
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOnHighLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getHighPressureThreshold());
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOnLowLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getLowPressureThreshold());
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

}
