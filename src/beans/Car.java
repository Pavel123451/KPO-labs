package beans;

import java.util.Scanner;

public class Car {
    private final static int BRAND_FIELD_NUMBER = 0;
    private final static int ENGINE_VOLUME_FIELD_NUMBER = 1;
    private String brand;
    private double engineVolume;

    public Car(String brand, double engineVolume) {
        if (engineVolume < 0.001) {
            throw new IllegalArgumentException(
                    "Engine volume can't be < 0.001");
        }
        this.brand = brand;
        this.engineVolume = engineVolume;
    }

    public Car(String[] fields) {
        this(getValidCar(fields));
    }

    public Car(Car car) {
        this(car.brand, car.engineVolume);
    }

    private static Car getValidCar(String[] fields) {
        if (fields.length != 2) {
            throw new ArrayIndexOutOfBoundsException(
                    "args number for Car can't be != 2");
        }
        return new Car(fields[BRAND_FIELD_NUMBER],
                Double.parseDouble(fields[ENGINE_VOLUME_FIELD_NUMBER]));
    }

    public String getBrand() {
        return brand;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return brand + " " + engineVolume;
    }

}
