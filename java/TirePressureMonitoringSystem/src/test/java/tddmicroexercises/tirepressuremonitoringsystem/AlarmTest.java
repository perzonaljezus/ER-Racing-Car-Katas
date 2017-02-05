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
        double tooLowPressure = Alarm.lowPressureThreshold -1;
        ISensor sensor = new SensorThatProbes(tooLowPressure);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsNormal() {
        double normalPressure = (Alarm.highPressureThreshold + Alarm.lowPressureThreshold)/2;
        ISensor sensor = new SensorThatProbes(normalPressure);
        Alarm alarm = new Alarm(sensor, safetyRange);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
