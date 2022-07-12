package com.gmail.dmitriykatinn;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<City> cities = CityUtils.parse();
        sortTask(cities);
        maxPopulationTask(cities);
        regionTask(cities);
    }

    private static void regionTask(List<City> cities){
        Map<String, Integer> cityCounter = new HashMap<>();
        for(City city : cities){
            String region = city.getRegion();
            cityCounter.put(region, cityCounter.getOrDefault(region, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : cityCounter.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static void maxPopulationTask(List<City> cities) {
        int index = 0;
        int maxPopulation = cities.get(index).getPopulation();
        for(int i = 0; i < cities.size(); i++){
            int curPopulation = cities.get(i).getPopulation();
            if(curPopulation > maxPopulation){
                index = i;
                maxPopulation = curPopulation;
            }
        }
        System.out.println("[" + index + "] = " + maxPopulation);
    }

    private static void sortTask(List<City> list){
        List<City> cities = new ArrayList<>(list);
        Comparator<City> compareByName =
                (o1, o2) -> (o1.getName().compareToIgnoreCase(o2.getName()));
        Comparator<City> compareByDistrict = Comparator.comparing(City::getDistrict);

        cities.sort(compareByName);
        cities.forEach(System.out::println);

        cities.sort(compareByDistrict.thenComparing(compareByName));
        cities.forEach(System.out::println);
    }
}