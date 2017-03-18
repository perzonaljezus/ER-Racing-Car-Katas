package tddmicroexercises.tirepressuremonitoringsystem.safetyrange;

/**
 * Created by pj on 16/03/2017.
 */
public class SafetyRangeWetTire extends SafetyRange {
    public static double lowPressureThreshold = 15. ;
    public static double highPressureThreshold = 25. ;

    public SafetyRangeWetTire(double lowPressureThreshold, double highPressureThreshold) {
        super(lowPressureThreshold, highPressureThreshold);
    }
}
