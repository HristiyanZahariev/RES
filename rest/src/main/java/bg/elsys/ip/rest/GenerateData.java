package bg.elsys.ip.rest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.awt.Color.black;

/**
 * Created by hristiyan on 14.11.16.
 */
public class GenerateData {

    private static List<Car> cars = new ArrayList<>();

    public static List<Car> getCars() {
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(getRandomManufacture(), getRandomModel(), getRandomYear(), getRandomColor()));
        }
       return cars;
    }

    public static String getRandomManufacture() {
        String[] manufacturers = {"BMW", "Mercedes", "Vw", "Audi", "Opel", "Renault"};
        int randomIndex = new Random().nextInt(manufacturers.length); //copi pasta from here: http://stackoverflow.com/questions/13340516/random-element-from-string-array
        return manufacturers[randomIndex];
    }

    public static int getRandomYear() {
        Random rand = new Random();
        int maxYear = 2016;
        int minYear = 1940;
        int range = maxYear - minYear;

        return rand.nextInt(range) + minYear; //This will generate an year from 1940 to 2016
    }

    public static String getRandomColor() {
        String[] colors = {"white", "blue", "black", "yellow", "green", "gray"};
        int randomIndex = new Random().nextInt(colors.length);
        return colors[randomIndex];

    }


    public static String getRandomModel() {
        int randomNumber = new Random().nextInt(100) + 1;
        return "" + (char) ('A' + new Random().nextInt('Z' - 'A')) + randomNumber;

    }

    public static boolean addNewCar(Car car) {
        return cars.add(car);

    }

    public static List<String> getAllManufacturersNames() {
        return cars.stream()
                .map((u) -> u.getManufacture())
                .distinct()
                .collect(Collectors.toList());
    }

    public static Car findById(int id) {
       for (Car car : cars) {
           if (car.getId() == id)
               return car;
       }

       return null;
    }
}
