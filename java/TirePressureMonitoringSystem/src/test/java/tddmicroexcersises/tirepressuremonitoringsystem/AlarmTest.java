package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {
    Sensor sensor;


    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double okPressure = (TestableAlarm.highPressureThreshold+ TestableAlarm.lowPressureThreshold)/2;
        sensor = new Sensor();
        Alarm alarm = new TestableAlarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        Alarm alarm = new TestableAlarm(TestableAlarm.highPressureThreshold +1);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        Alarm alarm = new TestableAlarm(TestableAlarm.lowPressureThreshold -1);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    private class TestableAlarm extends Alarm {
        private double mockPressure;

        public TestableAlarm(Sensor sensor) {
            super(sensor);
        }

        protected double pressureValue() {
            return mockPressure ;
        }
    }
}
