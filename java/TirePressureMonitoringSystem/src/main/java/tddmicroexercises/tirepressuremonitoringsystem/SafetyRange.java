package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 15/01/17.
 */
@SuppressWarnings("DefaultFileTemplate")
class SafetyRange {
    private final double lowPressureThreshold;
    private final double highPressureThreshold;

    public SafetyRange(double lowPressureThreshold, double highPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
        this.highPressureThreshold = highPressureThreshold;
    }

    public boolean isInSafetyRange(double samplePressure) {
        return (lowPressureThreshold <= samplePressure) && (samplePressure <= highPressureThreshold);
    }

}
