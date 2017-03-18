package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTest {
    @Mock
    private Sensor sensor;

    @Mock
    private SafetyRange safetyRange;

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        given(safetyRange.midValue()).willReturn(20.);
        double okPressure = safetyRange.midValue();

        given(sensor.popNextPressurePsiValue()).willReturn(okPressure);

        Alarm alarm = new Alarm(sensor, safetyRange);

        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
