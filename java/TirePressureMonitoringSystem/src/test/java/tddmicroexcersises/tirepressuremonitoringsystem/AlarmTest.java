package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;
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
    private SafetyRange safetyRange;


    @Before
    public void setup() {
        this.safetyRange = new SafetyRange(17. , 21.);
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOk() {
        given(sensor.popNextPressurePsiValue()).willReturn(19.); // (high+low)/2
        Alarm alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        given(sensor.popNextPressurePsiValue()).willReturn(22.); // high +1
        Alarm alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        given(sensor.popNextPressurePsiValue()).willReturn(16.); // low -1
        Alarm alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
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
        assertFalse(alarm.isAlarmOn());
    }

    private AlarmBuilder anAlarm() {
        return new AlarmBuilder();
    }

    private class AlarmBuilder {
        private Sensor sensor;
        private SafetyRange safetyRange;

        public AlarmBuilder usingSensor(Sensor sensor) {
            this.sensor = sensor;
            return this;
        }

        public AlarmBuilder andWithSafetyRange(SafetyRange safetyRange) {
            this.safetyRange = safetyRange;
            return this;
        }

        public Alarm build() {
            Alarm alarm = new Alarm(this.sensor, this.safetyRange);
            return alarm;
        }
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOnLowLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(17.); // low
        Alarm alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
