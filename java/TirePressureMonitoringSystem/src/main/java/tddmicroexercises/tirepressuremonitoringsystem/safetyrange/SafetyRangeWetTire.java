package tddmicroexercises.tirepressuremonitoringsystem.safetyrange;

/**
 * Created by pj on 18/03/2017.
 */
public class SafetyRangeWetTire implements SafetyRange {
    private final double lowPressureThreshold = 15. ;
    private final double highPressureThreshold = 25. ;

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
