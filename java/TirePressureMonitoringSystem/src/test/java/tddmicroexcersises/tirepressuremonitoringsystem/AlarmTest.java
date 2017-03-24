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
        Alarm alarm = new Alarm();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    // test alarm is on when pressure is too high
    // test alarm is on when pressure is too low
    // test alarm is off when pressure on high limit
    // test alarm is off when pressure on low limit
}
