package bg.elsys.ip.rest;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * Created by hristiyan on 14.11.16.
 */
public class GenerateData {

    private static GenerateData INSTANCE = null;
    private  List<Car> cars = new ArrayList<>();

    private GenerateData() {
        initCars();
    }

    public static GenerateData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GenerateData();
        }
        return INSTANCE;
    }

    public void initCars() {
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(getRandomManufacture(), getRandomModel(), getRandomYear(), getRandomColor()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getRandomManufacture() {
        String[] manufacturers = {"BMW", "Mercedes", "Vw", "Audi", "Opel", "Renault"};
        int randomIndex = new Random().nextInt(manufacturers.length); //copi pasta from here: http://stackoverflow.com/questions/13340516/random-element-from-string-array
        return manufacturers[randomIndex];
    }

    public int getRandomYear() {
        Random rand = new Random();
        int maxYear = 2016;
        int minYear = 1940;
        int range = maxYear - minYear;

        return rand.nextInt(range) + minYear; //This will generate an year from 1940 to 2016
    }

    public String getRandomColor() {
        String[] colors = {"white", "blue", "black", "yellow", "green", "gray"};
        int randomIndex = new Random().nextInt(colors.length);
        return colors[randomIndex];

    }

    public String getRandomModel() {
        int randomNumber = new Random().nextInt(100) + 1;
        return "" + (char) ('A' + new Random().nextInt('Z' - 'A')) + randomNumber;

    }

    public boolean addNewCar(Car car) {
        return cars.add(car);

    }

    public List<String> getAllManufacturersNames() {
        return cars.stream()
                .map((u) -> u.getManufacture())
                .distinct()
                .collect(Collectors.toList());
    }

    public  Car findById(int id) {
       for (Car car : cars) {
           if (car.getId() == id)
               return car;
       }

       return null;
    }
}
