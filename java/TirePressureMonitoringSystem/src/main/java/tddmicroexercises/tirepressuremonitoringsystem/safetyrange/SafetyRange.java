package tddmicroexercises.tirepressuremonitoringsystem.safetyrange;

/**
 * Created by pj on 16/03/2017.
 */
public class SafetyRange {
    public static double lowPressureThreshold ;
    public static double highPressureThreshold ;

    protected SafetyRange(double lowPressureThreshold, double highPressureThreshold) {
        this.lowPressureThreshold = lowPressureThreshold;
        this.highPressureThreshold = highPressureThreshold;
    }

    public boolean isInSafetyRange(double psiPressureValue) {
        return lowPressureThreshold <= psiPressureValue && psiPressureValue <= highPressureThreshold;
    }
}
