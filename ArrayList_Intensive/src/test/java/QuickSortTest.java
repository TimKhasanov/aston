import org.example.Car;
import org.example.MyArrayList;

import org.example.QuickSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    /**
     * Создаем ссылку на объект который будем тестировать
     */
    MyArrayList<Car> carMyArrayList;
    MyArrayList<Integer> myArrayList;

    /**
     * Перед каждым тестом создаем 2 новых ArrayList,
     * в carMyArrayList добавляем объект Car,
     * в myArrayList добавляем Int
     */
    @BeforeEach
    void setUp() {
        carMyArrayList = new MyArrayList<>();
        carMyArrayList.add(new Car(1, "Acura"));
        carMyArrayList.add(new Car(3, "Aston Martin"));
        carMyArrayList.add(new Car(2, "Audi"));
        carMyArrayList.add(new Car(4, "BMW"));
        myArrayList = new MyArrayList<>();
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(1);
    }

    /**
     * Проверяем коллекцию после сортировки объектов по Id
     */
    @Test
    public void whenSortingIsCalledTheArrayIsSortedById() {
        //
        // Given
        //
        Car getShouldElement = carMyArrayList.get(0);
        Car getShouldElement1 = carMyArrayList.get(2);
        Car getShouldElement2 = carMyArrayList.get(1);
        Car getShouldElement3 = carMyArrayList.get(3);
        //
        // When
        //
        QuickSort.sort(carMyArrayList, Comparator.comparingInt(Car::getId));
        Car setElement = carMyArrayList.get(0);
        Car setElement1 = carMyArrayList.get(1);
        Car setElement2 = carMyArrayList.get(2);
        Car setElement3 = carMyArrayList.get(3);
        //
        // Then
        //
        assertEquals(getShouldElement, setElement);
        assertEquals(getShouldElement1, setElement1);
        assertEquals(getShouldElement2, setElement2);
        assertEquals(getShouldElement3, setElement3);
    }

    /**
     * Проверяем коллекцию после сортировки по естественному порядку
     */
    @Test
    public void whenCalledTheArrayIsSortedByNaturalOrder() {
        //
        // Given
        //
        Integer getShouldElement = 1;
        Integer getShouldElement1 = 2;
        Integer getShouldElement2 = 3;
        Integer getShouldElement3 = 4;
        //
        // When
        //
        QuickSort.sort(myArrayList, Comparator.naturalOrder());
        Integer setElement = myArrayList.get(0);
        Integer setElement1 = myArrayList.get(1);
        Integer setElement2 = myArrayList.get(2);
        Integer setElement3 = myArrayList.get(3);
        //
        // Then
        //
        assertEquals(getShouldElement, setElement);
        assertEquals(getShouldElement1, setElement1);
        assertEquals(getShouldElement2, setElement2);
        assertEquals(getShouldElement3, setElement3);
    }


}
