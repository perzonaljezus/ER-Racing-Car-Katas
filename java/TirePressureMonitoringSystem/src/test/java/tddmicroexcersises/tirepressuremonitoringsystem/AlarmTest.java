package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.ISensor;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;
import static tddmicroexercises.tirepressuremonitoringsystem.AlarmBuilder.anAlarm;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTest {
    @Mock
    private ISensor sensor;

    private SafetyRange safetyRange = new SafetyRange();

    private Alarm alarm;

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double pressure = safetyRange.midThreshold();
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        double pressure = safetyRange.highThreshold() + 1;
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        double pressure = safetyRange.lowThreshold() - 1;
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsExactlyHighThreshold() {
        double pressure = safetyRange.highThreshold();
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsExactlyLowThreshold() {
        double pressure = safetyRange.lowThreshold();
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

}
