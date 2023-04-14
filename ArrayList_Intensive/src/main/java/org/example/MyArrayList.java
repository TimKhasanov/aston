package org.example;


import java.util.Arrays;

/**
 * Реализация ArrayList.
 *
 * @param <T>> обобщенный тип
 * @author Timur Khasanov
 * @version 1
 */
public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] data;
    /**
     * Создает коллекцию с заданным начальным размером
     * @param capacity размер коллекции при инициализации
     *
     * @throws IllegalArgumentException будет выброшено,
     * при попытке инициализировать коллекцию размером меньше 0
     */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0");
        } else {
            data = new Object[capacity];
        }
    }

    /**
     * Метод создает коллекцию по умолчанию
     */
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    /**
     * Добавление элемента в конец коллекции
     *
     * @param element добавляемый в коллекцию элемент
     */
    public void add(T element) {
        //Выполняем проверку на заполненность нашего ArrayList
        if (size == data.length) {
            ensureCapacity();
        }
        data[size++] = element;
    }

    /**
     * Размер коллекции
     *
     * @return текущий размер коллекции
     */
    public int size() {
        return size;
    }
    /**
     * Метод поиска элемента в коллекции по индексу
     *
     * @param index
     * @return выбранный элемент коллекции
     */
    public T get(int index) {
        checkingIndex(index);
        return (T) data[index];
    }

    /**
     * Метод удаление элемента по заданному элементу
     *
     * @param element
     */
    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                remove(i);
            }
        }
    }

    /**
     * Удаление элемента по заданному индексу
     *
     * @param index индекс удаляемого элемента
     * @throws IndexOutOfBoundsException если элемента с таким index не существует.
     */
    public void remove(int index) {
        checkingIndex(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;

    }
    /**
     * Метод очищает коллекцию
     */
    public void clear(){
        data = new Object[10];
        size = 0;
    }
    /**
     * Установка элемента по заданному индексу
     *
     * @param object устанавливаемый элемент
     * @param index индекс элемента который будет установлен
     * @throws IndexOutOfBoundsException если элемента с таким index не существует.
     */
    public void set(T object, int index) {
        checkingIndex(index);
        data[index] = object;
    }

    /**
     * Метод увеличение коллекции в 2 раза, если коллекция заполнена
     */
    private void ensureCapacity() {
        int newCapacity = data.length * 2;
        Object[] elementData = new Object[newCapacity];
        System.arraycopy(data, 0, elementData, 0, size);
        data = elementData;
    }

    /**
     * Проверка по индексу в коллекции
     * @throws IndexOutOfBoundsException будет выброшено,
     если в коллекции нет элемента соответствующему запросу
     */
    private void checkingIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Элемента c " + index + " индексом не существует");

    }

    /**
     * Метод, который выводит элементы находящиеся в коллекции
     * @return выводит все элементы в коллекции
     */
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}

