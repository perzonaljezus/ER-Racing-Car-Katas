package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        Alarm alarm = new TestableAlarm(20.);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        Alarm alarm = new TestableAlarm(22.);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    private class TestableAlarm extends Alarm {
        private double mockPressure;

        public TestableAlarm(double mockPressure) {
            super();

            this.mockPressure = mockPressure;
        }

        protected double pressureValue() {
            return mockPressure ;
        }
    }
}
