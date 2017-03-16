package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 16/03/2017.
 */
public class SafetyRange {
    protected double lowPressureThreshold;
    protected double highPressureThreshold;

    public SafetyRange(double lowPressureThreshold, double highPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
        this.highPressureThreshold = highPressureThreshold;
    }

    protected boolean isInSafetyRange(double psiPressureValue) {
        return lowPressureThreshold <= psiPressureValue && psiPressureValue <= highPressureThreshold;
    }
}
