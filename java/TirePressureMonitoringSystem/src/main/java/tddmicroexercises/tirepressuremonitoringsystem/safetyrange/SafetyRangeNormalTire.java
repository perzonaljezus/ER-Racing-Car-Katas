package tddmicroexercises.tirepressuremonitoringsystem.safetyrange;

/**
 * Created by pj on 16/03/2017.
 */
public class SafetyRangeNormalTire extends SafetyRange {
    public static double lowPressureThreshold = 17. ;
    public static double highPressureThreshold = 21. ;

    public SafetyRangeNormalTire(double lowPressureThreshold, double highPressureThreshold) {
        super(lowPressureThreshold, highPressureThreshold);
    }
}
