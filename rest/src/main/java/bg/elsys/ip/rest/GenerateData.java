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

    private static GenerateData instance = null;

    private static final List<Car> cars = new ArrayList<>();

    protected GenerateData() {
        initCars();
    }

    public static GenerateData getInstance() {
        if (instance == null) {
            instance = new GenerateData();
        }

        return instance;
    }

    public void initCars() {
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(getRandomManufacture(), getRandomModel(), getRandomYear(), getRandomColor()));
        }
    }

    public List getCars() {
        return cars;
    }

    public Manufacture getRandomManufacture() {
        Manufacture[] manufcaturers = Manufacture.values();
        int idx = new Random().nextInt(manufcaturers.length); //copy pasta dis from http://stackoverflow.com/questions/13340516/random-element-from-string-array
        return manufcaturers[idx];
    }

    public int getRandomYear() {
        Random rand = new Random();
        int maxYear = 2016;
        int minYear = 1940;
        int range = maxYear - minYear;

        return rand.nextInt(range) + minYear; //This will generate an year from 1940 to 2016
    }

    public Color getRandomColor() {
        Color[] colors = Color.values();
        int idx = new Random().nextInt(colors.length);
        return colors[idx];

    }


    public String getRandomModel() {
        int randomNumber = new Random().nextInt(100) + 1;
        return "Model " + (char) ('A' + new Random().nextInt('Z' - 'A')) + randomNumber;

    }

    public boolean addNewCar(Car car) {
        return cars.add(car);

    }

    public Car findById(int id) {
       for (Car car : cars) {
           if (car.getId() == id)
               return car;
       }

       return null;
    }
}
