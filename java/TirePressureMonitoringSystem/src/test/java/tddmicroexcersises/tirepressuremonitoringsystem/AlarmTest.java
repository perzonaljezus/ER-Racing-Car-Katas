package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.Sensor;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by pj on 15/01/17.
 */
public class AlarmTest {

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        double tooHighPressure = Alarm.highPressureThreshold +1;
        Sensor sensor = new MockSensor(tooHighPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        double tooLowPressure = Alarm.lowPressureThreshold -1;
        Sensor sensor = new MockSensor(tooLowPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }
    @Test
    public void testAlarmIsOnWhenPressureIsNormal() {
        double normalPressure = (Alarm.highPressureThreshold + Alarm.lowPressureThreshold)/2;
        Sensor sensor = new MockSensor(normalPressure);
        Alarm alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
