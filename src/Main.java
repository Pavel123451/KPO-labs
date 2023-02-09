import beans.Car;
import beans.Cat;
import comparators.CarBrandComparator;
import comparators.CarEngineVolumeComparator;
import comparators.CatComparator;
import services.Sorter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String catsFileName = "src/cats.csv";
        String delimeter = ";";
        try (Scanner sc = new Scanner(new FileReader(catsFileName))) {
            List<Cat> cats = new ArrayList<>();
            while (sc.hasNext()) {
                String[] fields = sc.nextLine().split(delimeter);
                try {
                    cats.add(new Cat(fields));
                } catch (IllegalArgumentException |
                         ArrayIndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                }

            }
            for (Cat cat : cats) {
                System.out.println(cat);
            }
            Cat[] catsArray = cats.toArray(new Cat[0]);
            Sorter.sort(catsArray, new CatComparator());
            System.out.println();
            System.out.println();
            for (Cat cat : catsArray) {
                System.out.println(cat);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File with cats is not found");
        }
        String carsFileName = "src/cars.csv";
        try (Scanner sc = new Scanner(new FileReader(carsFileName))) {
            List<Car> cars = new ArrayList<>();
            while (sc.hasNext()) {
                String[] fields = sc.nextLine().split(delimeter);
                try {
                    cars.add(new Car(fields));
                } catch (IllegalArgumentException |
                         ArrayIndexOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                }

            }
            System.out.println();
            System.out.println("Cars:");
            System.out.println();
            for (Car car : cars) {
                System.out.println(car);
            }
            Car[] carsArray = cars.toArray(new Car[0]);
            Sorter.sort(carsArray, new CarBrandComparator());
            System.out.println();
            System.out.println("Cars after sort with CarBrandComparator:");
            System.out.println();
            for (Car car : carsArray) {
                System.out.println(car);
            }
            Sorter.sort(carsArray, new CarEngineVolumeComparator());
            System.out.println();
            System.out.println("Cars after sort with CarEngineVolumeComparator:");
            System.out.println();
            for (Car car : carsArray) {
                System.out.println(car);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File with cars is not found");
        }
    }
}