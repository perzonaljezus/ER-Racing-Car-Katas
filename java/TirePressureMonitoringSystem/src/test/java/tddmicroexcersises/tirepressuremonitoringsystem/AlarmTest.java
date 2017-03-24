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
        double pressure = 19; // (high + low) 2
        FakeAlarm alarm = new FakeAlarm(pressure);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    private class FakeAlarm extends Alarm {
        private double pressure;

        public FakeAlarm(double pressure) {
            this.pressure = pressure;
        }
        protected double pressureValue() {
            return pressure;
        }
    }


    // test alarm is on when pressure is too high
    // test alarm is on when pressure is too low
    // test alarm is off when pressure on high limit
    // test alarm is off when pressure on low limit
}
