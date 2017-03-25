package tddmicroexercises.tirepressuremonitoringsystem.safetyRange;

/**
 * Created by pj on 25/03/2017.
 */
public interface SafetyRange {
    double lowPressureThreshold = 0;
    double highPressureThreshold = 0;

    double getLowPressureThreshold();

    double getHighPressureThreshold();
}
