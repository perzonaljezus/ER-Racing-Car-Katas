package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 24/03/2017.
 */
public class SafetyRangeWetTire {
    private double lowPressureThreshold;
    private double highPressureThreshold;

    public SafetyRangeWetTire() {
        this.lowPressureThreshold = 15. ;
        this.highPressureThreshold = 25. ;
    }

    public double getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public double getHighPressureThreshold() {
        return highPressureThreshold;
    }

}
