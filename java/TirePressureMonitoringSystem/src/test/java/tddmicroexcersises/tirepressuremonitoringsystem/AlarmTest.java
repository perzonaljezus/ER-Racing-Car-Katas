package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
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

    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        given(sensor.popNextPressurePsiValue()).willReturn(16.); // low -1
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOnHighLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(21.); // high
        Alarm alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    private AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    private class AlarmBuilder {
        private Sensor sensor;

        public AlarmBuilder usingSensor(Sensor sensor) {
            this.sensor = sensor;
            return this;
        }
    }

    // test alarm is off when pressure on low limit
}
