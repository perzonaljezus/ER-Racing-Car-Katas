package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 24/03/2017.
 */
public class SafetyRange {
    private double lowPressureThreshold;
    private double highPressureThreshold;

    public SafetyRange(double lowPressureThreshold, double highPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
        this.highPressureThreshold = highPressureThreshold;
    }

    public double getLowPressureThreshold() {
        return lowPressureThreshold;
    }

    public double getHighPressureThreshold() {
        return highPressureThreshold;
    }

}
