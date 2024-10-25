package com.example.lab8;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for mycity
     * @return
     * returns the mocklist object
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * test if addCity object does actually add a new object
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();

        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    /**
     * make a customList object
     * make sure the customList doesn't have the city object
     * add the city object and make sure the customList has it
     */
    @Test
    public void hasCityTest() {
        City myCity = new City("Edmonton", "AB");
        list = MockCityList();
        list.addCity(new City("Toronto", "ON"));

        assertFalse(list.hasCity(myCity));
        list.addCity(myCity);
        assertTrue(list.hasCity(myCity));
    }

    /**
     * make an empty customlist object
     * add a new city object into the list
     * make sure the customlist has that new city object
     * delete the city object
     * make sure the customlist no longer has the new city object
     */
    @Test
    public void deleteCityTest() {
        City myCity = new City("Vancouver", "BC");
        list = MockCityList();

        list.addCity(myCity);
        assertTrue(list.hasCity(myCity));

        list.delete(myCity);
        assertFalse(list.hasCity(myCity));

        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(myCity);
        });
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void countCityTest() {
        list = MockCityList();
        int count = 0;
        assertEquals(count, list.countCities());
        City myCity = new City("Edmonton", "AB");

        list.addCity(myCity);
        count++;
        assertEquals(list.countCities(), count);
    }
}
