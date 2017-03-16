package tddmicroexercises.tirepressuremonitoringsystem;

/**
 * Created by pj on 05/02/17.
 */
public class TelemetryPressureSensor extends Sensor implements ISensor {
    @Override
    public double probe(){
        return super.popNextPressurePsiValue();
    }
}
