package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 18/03/2017.
 */
public class SafetyRange {
    private final double lowPressureThreshold = 17. ;
    private final double highPressureThreshold = 21. ;

    public double midValue() {
        return (lowPressureThreshold + highPressureThreshold) / 2;
    }

    public double getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public double getHighPressureThreshold() {
        return highPressureThreshold;
    }

}
