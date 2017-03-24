package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOffWhenPressureIsOk() {
        double pressure = 19; // (high + low) / 2
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

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        Sensor sensor = new Sensor() {
            public double popNextPressurePsiValue(){
                return 22; // high +1
            }
        };
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    // test alarm is on when pressure is too low
    // test alarm is off when pressure on high limit
    // test alarm is off when pressure on low limit
}
