package org.example;
import java.util.Comparator;
import java.util.Random;
/**
 * Реализация QuickSort.
 *
 * @param <T>> обобщенный тип
 * @author Timur Khasanov
 * @version 1
 */

public class QuickSort <T extends Comparable<T>> {
    /**
     * Публичный метод сортировки коллекции
     *
     * @param list элементы коллекции
     * @param comparator компаратор
     */
    public static <T> void sort(MyArrayList<T> list, Comparator<T> comparator) {
        // Если список равен нулю или содержит менее 2 элементов, сортировать не нужно
        if (list == null || list.size() <= 1) {
            return;
        }
        int low = 0;
        int high = list.size() - 1;
        partition(list, low, high, comparator);
    }

    /**
     * Метод логики сортировки коллекции
     *
     * @param list элементы коллекции
     * @param left левый элемент
     * @param right правый элемент
     * @param comparator компаратор
     */
    private static <T> void partition(MyArrayList<T> list, int left, int right, Comparator<T> comparator) {
        int leftValue = left;
        int rightValue = right;
        T pivot = list.get(new Random().nextInt(rightValue - leftValue + 1) + leftValue);
        do {
            while (comparator.compare(list.get(leftValue), pivot) < 0) {
                leftValue++;
            }
            while (comparator.compare(list.get(rightValue), pivot) > 0) {
                rightValue--;
            }
            if (leftValue <= rightValue) {
                if (leftValue < rightValue) {
                    T tmp = list.get(leftValue);
                    list.set(leftValue, list.get(rightValue));
                    list.set(rightValue, tmp);
                }
                leftValue++;
                rightValue--;
            }
        } while (leftValue <= rightValue);
        // Выполнение метода рекурсивно для двух частей
        if (leftValue < right) {
            partition(list, leftValue, right, comparator);
        }
        if (left < rightValue) {
            partition(list, left, rightValue, comparator);
        }
    }
}