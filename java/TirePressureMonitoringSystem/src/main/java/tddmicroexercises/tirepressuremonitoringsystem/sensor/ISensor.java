package tddmicroexercises.tirepressuremonitoringsystem.sensor;

/**
 * Created by pj on 18/03/2017.
 */
public interface ISensor {
    double OFFSET = 16;

    double popNextPressurePsiValue();
}
