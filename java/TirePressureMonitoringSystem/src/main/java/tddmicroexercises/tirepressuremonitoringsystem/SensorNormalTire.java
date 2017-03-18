package tddmicroexercises.tirepressuremonitoringsystem;

import tddmicroexercises.tirepressuremonitoringsystem.legacy.Sensor;

/**
 * Created by pj on 18/03/2017.
 */
// adapter class for Sensor, so that we decouple the Sensor from any code, so that we can apply refactorings to the normal and wet cases equally.
public class SensorNormalTire extends Sensor implements ISensor {
}
