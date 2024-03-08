package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @org.junit.Test
    public void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    public void testDelete() {
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.getCount()); // Assuming getCount() returns the number of cities in the list

        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);

        assertEquals(1, cityList.getCount()); // Ensure city was added

        cityList.delete(city);

        assertEquals(0, cityList.getCount()); // Ensure city was deleted
        assertFalse(cityList.hasCity("Regina"));
    }

    @org.junit.Test
    public void testCountCity() {
        CustomList cityList = MockCityList();
        Assert.assertEquals(1, cityList.countCities());
        City city = new City("Calgary","Alberta");
        cityList.add(city);
        City city2 = new City("Banff","Alberta");
        cityList.add(city2);
        Assert.assertEquals(3, cityList.countCities());
    }

}
