package com.example.lab08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList {
    private List<City> cities;

    public CustomList() {
        this.cities = new ArrayList<>();
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public void deleteCity(City city) { //adapted from https://www.baeldung.com/java-concurrentmodificationexception
        for (Iterator<City> iterator = cities.iterator(); iterator.hasNext();) {
            City cityInList = iterator.next();
            if (cityInList.getCityName().equals(city.getCityName())) {
                if (cityInList.getProvinceName().equals(city.getProvinceName())) {
                    iterator.remove();
                }
            }
        }
    }

    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    public int countCities() {
        return cities.size();
    }
}
