package comparators;

import beans.Cat;

import java.util.Comparator;

public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat cat1, Cat cat2) {
        if (cat1.getBreed().equals(cat2.getBreed())) {
            if (!cat1.getName().equals(cat2.getName())) {
                return cat1.getName().compareTo(cat2.getName());
            } else {
                return cat1.getAge() - cat2.getAge();
            }
        } else {
            return cat1.getBreed().compareTo(cat2.getBreed());
        }
    }
}
