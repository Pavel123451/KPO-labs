package comparators;

import beans.Car;

import java.util.Comparator;

public class CarEngineVolumeComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if ((car1.getEngineVolume() - car2.getEngineVolume()) < 0) {
            return -1;
        }
        if ((car1.getEngineVolume() - car2.getEngineVolume()) > 0) {
            return 1;
        }
        return 0;
    }
}
