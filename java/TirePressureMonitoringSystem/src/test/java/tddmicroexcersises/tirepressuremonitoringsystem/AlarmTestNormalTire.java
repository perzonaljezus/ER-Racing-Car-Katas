package tddmicroexcersises.tirepressuremonitoringsystem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddmicroexercises.tirepressuremonitoringsystem.AlarmNormalTire;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRangeNormalTire;
import tddmicroexercises.tirepressuremonitoringsystem.legacy.Sensor;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.given;
import static tddmicroexcersises.tirepressuremonitoringsystem.AlarmBuilderNormalTire.anAlarm;

/**
 * Created by pj on 15/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AlarmTestNormalTire {
    @Mock
    private Sensor sensor;
    private SafetyRangeNormalTire safetyRange;
    private AlarmNormalTire alarm;



    @Before
    public void setup() {
        this.safetyRange = new SafetyRangeNormalTire(17. , 21.);
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOk() {
        given(sensor.popNextPressurePsiValue()).willReturn((safetyRange.getHighPressureThreshold() + safetyRange.getLowPressureThreshold()) /2);
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooHigh() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getHighPressureThreshold() +1);
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsTooLow() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getLowPressureThreshold() -1);
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOnHighLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getHighPressureThreshold());
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenPressureIsOnLowLimit() {
        given(sensor.popNextPressurePsiValue()).willReturn(safetyRange.getLowPressureThreshold());
        alarm = anAlarm().
                usingSensor(sensor).
                andWithSafetyRange(safetyRange).
                build();
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }

}
