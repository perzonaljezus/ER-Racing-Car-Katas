package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTest {
    @Mock
    private Sensor sensor;


    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double okPressure = (SafetyRange.highPressureThreshold + SafetyRange.lowPressureThreshold)/2;
        given(sensor.popNextPressurePsiValue()).willReturn(okPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        given(sensor.popNextPressurePsiValue()).willReturn(SafetyRange.highPressureThreshold +1);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        given(sensor.popNextPressurePsiValue()).willReturn(SafetyRange.lowPressureThreshold -1);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOffWhenPressureIsLowLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(SafetyRange.lowPressureThreshold);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOffWhenPressureIsHighLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(SafetyRange.highPressureThreshold);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }


}
