package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 14/01/17.
 */
@SuppressWarnings("DefaultFileTemplate")
class SensorThatProbes extends TelemetryPressureSensor {

    private final double value;

    public SensorThatProbes(double _value) {
        value = _value;
    }

    @Override
    public double popNextPressurePsiValue() {
        return value;
    }

}
