package tddmicroexercises.tirepressuremonitoringsystem.safetyRange;

/**
 * Created by pj on 24/03/2017.
 */
public class SafetyRangeNormalTire implements SafetyRange {
    private double lowPressureThreshold;
    private double highPressureThreshold;

    public SafetyRangeNormalTire() {
        this.lowPressureThreshold = 17. ;
        this.highPressureThreshold = 21. ;
    }

    @Override
    public double getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    @Override
    public double getHighPressureThreshold() {
        return highPressureThreshold;
    }

}
