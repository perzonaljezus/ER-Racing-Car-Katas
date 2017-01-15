package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import static org.junit.Assert.assertTrue;

/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        double tooHightPressure = Alarm.highPressureThreshold +1;
        FakeAlarm alarm = new FakeAlarm(tooHightPressure);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
}
