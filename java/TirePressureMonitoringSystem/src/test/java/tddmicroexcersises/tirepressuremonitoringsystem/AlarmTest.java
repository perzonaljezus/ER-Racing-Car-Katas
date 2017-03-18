package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTest {
    @Mock
    private Sensor sensor;

    private SafetyRange safetyRange = new SafetyRange();

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double pressure = safetyRange.midValue();
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        double pressure = safetyRange.getHighPressureThreshold() + 1;
        given(sensor.popNextPressurePsiValue()).willReturn(pressure);

        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    // too low pressure
    // pressure is exactly the low value, this allows us to understand the logic of Sensor i.e. whether the thresholds are inclusive or exclusive
    // pressure is exactly the high value, dto.
}
