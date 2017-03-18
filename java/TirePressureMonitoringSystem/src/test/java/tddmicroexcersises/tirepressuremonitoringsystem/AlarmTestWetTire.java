package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRangeWetTire;
import tddmicroexercises.tirepressuremonitoringsystem.ISensor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTestWetTire {
    @Mock
    private ISensor sensor;
    private SafetyRange safetyRange;


    @Before
    public void setUp() throws Exception {
        safetyRange = new SafetyRangeWetTire(SafetyRangeWetTire.lowPressureThreshold, SafetyRangeWetTire.highPressureThreshold);
    }

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double okPressure = (safetyRange.highPressureThreshold + safetyRange.lowPressureThreshold)/2;
        given(sensor.popNextPressurePsiValue()).willReturn(okPressure);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.highPressureThreshold +1);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.lowPressureThreshold -1);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOffWhenPressureIsLowLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.lowPressureThreshold);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOffWhenPressureIsHighLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.highPressureThreshold);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }


}
