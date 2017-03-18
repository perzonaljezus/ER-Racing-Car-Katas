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

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double okPressure = safetyRangeMidValue();
        given(sensor.popNextPressurePsiValue()).willReturn(okPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    protected double safetyRangeMidValue() {
        return (Alarm.highPressureThreshold + Alarm.lowPressureThreshold)/2;
    }
}
