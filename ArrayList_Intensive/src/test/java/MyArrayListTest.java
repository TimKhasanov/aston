import org.example.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {
    /**
     * Создаем ссылку на объект который будем тестировать
     */
    MyArrayList<String> myArrayList;

    /**
     * Перед каждым тестом создаем новый ArrayList,
     * добавляем в него 30 строк
     */
    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        for (int i = 0; i < 30; i++) {
            myArrayList.add("Test" + i);
        }
    }

    /**
     * Проверяем размер коллекции
     * после добавление в него 30 строк
     */
    @Test
    public void whenAdding30RowsTheArrayListShouldBeEqualTo30() {
        //
        // Then
        //
        assertEquals(30, myArrayList.size());
    }

    /**
     * Добавляем новый элемент в середину коллекции,
     * проверяем её размер и добавился ли элемент
     */
    @Test
    public void addingAnItemToTheMiddleOfACollection() {
        //
        // Given
        //
        String newElement = "New Element";
        //
        // When
        //
        myArrayList.add(15, newElement);
        String getElement = myArrayList.get(15);
        //
        // Then
        //
        assertEquals(newElement, getElement);
        assertEquals(31,myArrayList.size());
    }

    /**
     * Удаляем элемент с коллекции по индексу,
     * проверяем её размер
     */
    @Test
    public void whenDeletingARowByIndexTheSizeShouldBeReduced() {
        //
        // When
        //
        myArrayList.remove(12);
        //
        // Then
        //
        assertEquals(29, myArrayList.size());
    }

    /**
     * Удаляем элемент с коллекции,
     * проверяем размер коллекции и удалился ли элемент
     */
    @Test
    public void whenDeletingARowByElementTheSizeShouldBeReducedAndTheElementDeleted() {
        //
        // Given
        //
        String testElement = "Test16";
        //
        // When
        //
        myArrayList.remove("Test15");
        String getElement = myArrayList.get(15);
        //
        // Then
        //
        assertEquals(testElement, getElement);
        assertEquals(29, myArrayList.size());
    }

    /**
     * Очищаем всю коллекцию и проверяем ее размер
     */
    @Test
    public void afterClearingTheCollectionTheSizeShouldBeZero() {
        //
        // When
        //
        myArrayList.clear();
        //
        // Then
        //
        assertEquals(0, myArrayList.size());
    }

    /**
     * Проверяем метод получение элемента с коллекции по индексу
     */
    @Test
    public void afterRequestingAnElementByIndexTheMethodShouldReturnTheElement() {
        //
        // Given
        //
        String testElement = "Test15";
        //
        // When
        //
        String getElement = myArrayList.get(15);
        //
        // Then
        //
        assertEquals(testElement, getElement);
    }
}
