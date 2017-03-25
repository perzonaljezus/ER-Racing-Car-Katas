package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 24/03/2017.
 */
public class SafetyRangeNormalTire {
    private double lowPressureThreshold;
    private double highPressureThreshold;

    public SafetyRangeNormalTire() {
        this.lowPressureThreshold = 17. ;
        this.highPressureThreshold = 21. ;
    }

    public double getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public double getHighPressureThreshold() {
        return highPressureThreshold;
    }

}
