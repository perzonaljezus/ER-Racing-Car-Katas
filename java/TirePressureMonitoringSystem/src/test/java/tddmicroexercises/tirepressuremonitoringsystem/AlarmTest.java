package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static tddmicroexercises.tirepressuremonitoringsystem.AlarmBuilder.anAlarm;

/**
 * Created by pj on 15/01/17.
 */
@SuppressWarnings("DefaultFileTemplate")
public class AlarmTest {

    private static SafetyRange safetyRange;

    private Alarm alarm;

    @Before
    public void setUp() throws Exception {
        safetyRange = new SafetyRange(Alarm.lowPressureThreshold, Alarm.highPressureThreshold);
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        alarm = anAlarm().
                usingSensor(new SensorThatProbes(Alarm.highPressureThreshold +1)).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        alarm = anAlarm().
                usingSensor(new SensorThatProbes(Alarm.lowPressureThreshold -1)).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsNormal() {
        double meanPressure = (Alarm.highPressureThreshold + Alarm.lowPressureThreshold)/2;
        alarm = anAlarm().
                usingSensor(new SensorThatProbes(meanPressure)).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
