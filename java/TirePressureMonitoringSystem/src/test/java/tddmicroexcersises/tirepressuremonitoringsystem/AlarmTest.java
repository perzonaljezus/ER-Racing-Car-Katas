package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static org.junit.Assert.assertTrue;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        SensorMock sensor = new SensorMock(pressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    // test alarm is on when pressure is too high
    // test alarm is on when pressure is too low
    // test alarm is off when pressure on high limit
    // test alarm is off when pressure on low limit
}
