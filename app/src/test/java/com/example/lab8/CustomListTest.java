package com.example.lab8;


import static org.junit.jupiter.api.Assertions.*;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */

    private CustomList list;

    /**
     * create a mocklist for mycity
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();

        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest() {
        City myCity = new City("Edmonton", "AB");
        list = MockCityList();

        assertFalse(list.hasCity(myCity));
        list.addCity(myCity);
        assertTrue(list.hasCity(myCity));
    }

    @Test
    public void deleteCityTest() {
        City myCity = new City("Vancouver", "BC");
        list = MockCityList();

        list.addCity(myCity);
        assertTrue(list.hasCity(myCity));

        list.delete(myCity);
        assertFalse(list.hasCity(myCity));
    }

    @Test
    public void countCityTest() {

    }
}
