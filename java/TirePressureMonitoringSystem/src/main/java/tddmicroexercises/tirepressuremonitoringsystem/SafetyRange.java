package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 18/03/2017.
 */
public class SafetyRange {
    private final double lowPressureThreshold = 17. ;
    private final double highPressureThreshold = 21. ;

    public double midThreshold() {
        return (lowPressureThreshold + highPressureThreshold) / 2;
    }

    public double lowThreshold() {
        return lowPressureThreshold;
    }

    public double highThreshold() {
        return highPressureThreshold;
    }

}
