package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static org.junit.Assert.assertFalse;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        Alarm alarm = new TestableAlarm();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    private class TestableAlarm extends Alarm {
        protected double pressureValue() {
            return 20. ;
        }
    }
}
