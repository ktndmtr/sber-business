package com.gmail.dmitriykatinn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {

    public static List<City> parse(){
        String filepath = "resources/city_ru.csv";
        File file = new File(filepath);
        List<City> cities = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                cities.add(CityUtils.getCityFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static City getCityFromLine(String line){
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        int id = scanner.nextInt();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = "";
        if (scanner.hasNext())
            foundation = scanner.next();
        scanner.close();

        return new City(name,  region, district, population, foundation);
    }

}
