package beans;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class Cat {
    private final static int BREED_FIELD_NUMBER = 0;
    private final static int NAME_FIELD_NUMBER = 1;
    private final static int AGE_FIELD_NUMBER = 2;
    private final static int CatFieldsNumber = 3;
    private String breed;

    private String name;

    private int age;

    public Cat(String breed, String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be < 0");
        }
        this.breed = breed;
        this.name = name;
        this.age = age;
    }

    public Cat(Cat cat) {
        this(cat.breed, cat.name, cat.age);
    }

    public Cat(String[] fields) {
        this(getValidCat(fields));
    }

    private static Cat getValidCat(String[] fields) {
        if (fields.length != 3) {
            throw new ArrayIndexOutOfBoundsException(
                    "args number for Cat can't be != 3");
        }
        return new Cat(fields[BREED_FIELD_NUMBER], fields[NAME_FIELD_NUMBER],
                Integer.parseInt(fields[AGE_FIELD_NUMBER]));
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return breed + " " + name + " " + age;
    }
}
