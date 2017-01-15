package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by pj on 15/01/17.
 */
@SuppressWarnings("DefaultFileTemplate")
public class AlarmTest {

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        double tooHighPressure = Alarm.highPressureThreshold +1;
        Sensor sensor = new SensorThatProbes(tooHighPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        double tooLowPressure = Alarm.lowPressureThreshold -1;
        Sensor sensor = new SensorThatProbes(tooLowPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsNormal() {
        double normalPressure = (Alarm.highPressureThreshold + Alarm.lowPressureThreshold)/2;
        Sensor sensor = new SensorThatProbes(normalPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
