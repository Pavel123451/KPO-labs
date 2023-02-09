package services;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static <T> void sort(T[] sortArr, Comparator<T> comparator) {
        int firstSortedElemNum = 0;
        int lastSortedElemNum = sortArr.length - 1;
        quickSort(sortArr, firstSortedElemNum, lastSortedElemNum, comparator);
    }

    private static <T> void quickSort(T[] sortArr, int first, int last,
                                      Comparator<T> comparator) {
        if (sortArr.length < 2) {
            return;
        }
        if (first >= last) {
            return;
        }
        int middle = first + (last - first) / 2;
        T temp = sortArr[middle];
        int i = first;
        int j = last;
        while (i <= j) {
            while (comparator.compare(sortArr[i], temp) < 0) {
                i++;
            }
            while (comparator.compare(sortArr[j], temp) > 0) {
                j--;
            }
            if (i <= j) {
                T t = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = t;
                i++;
                j--;
            }
        }
        if (first < j)
            quickSort(sortArr, first, j, comparator);
        if (last > i)
            quickSort(sortArr, i, last, comparator);
    }
}
