package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        double tooHighPressure = Alarm.highPressureThreshold +1;
        FakeAlarm alarm = new FakeAlarm(tooHighPressure);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        double tooLowPressure = Alarm.lowPressureThreshold -1;
        FakeAlarm alarm = new FakeAlarm(tooLowPressure);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsNormal() {
        double normalPressure = (Alarm.highPressureThreshold + Alarm.lowPressureThreshold)/2;
        FakeAlarm alarm = new FakeAlarm(normalPressure);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
