import org.example.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {
    MyArrayList<String> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        for (int i = 0; i < 30; i++) {
            myArrayList.add("Test" + i);
        }
    }
    @Test
    public void whenAdding30RowsTheArrayListShouldBeEqualTo30(){
        assertEquals(30,myArrayList.size());
    }
    @Test
    public void addingAnItemToTheMiddleOfACollection(){
        String newElement = "New Element";
       // myArrayList.add(15,newElement);
        String getElement = myArrayList.get(15);
        assertEquals(newElement,getElement);
    }
    @Test
    public void whenDeletingARowByIndexTheSizeShouldBeReduced(){
        myArrayList.remove(12);
        assertEquals(29,myArrayList.size());
    }
    @Test
    public void whenDeletingARowByElementTheSizeShouldBeReducedAndTheElementDeleted(){
        String testElement = "Test16";
        myArrayList.remove("Test15");
        String getElement = myArrayList.get(15);
        assertEquals(testElement,getElement);
        assertEquals(29,myArrayList.size());
    }
    @Test
    public void afterClearingTheCollectionTheSizeShouldBeZero(){
        myArrayList.clear();
        assertEquals(0,myArrayList.size());
    }
    @Test
    public void afterRequestingAnElementByIndexTheMethodShouldReturnTheElement(){
        String testElement = "Test15";
        String getElement = myArrayList.get(15);
        assertEquals(testElement,getElement);
    }




}
