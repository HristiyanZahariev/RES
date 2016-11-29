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
        for (int i = 1; i <= 100; i++) {
            cars.add(new Car(getRandomManufacture(),
                            getRandomModel(),
                            getRandomYear(),
                            getRandomColor()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> filterCars(String manufacturer, String model, Integer year, String color, Integer currPage, Integer carsPerPage) {
        List<Car> filteredCars = cars.stream().filter(car -> car.getManufacture().equals(manufacturer) || ("").equals(manufacturer) || manufacturer == null)
                .filter(car -> car.getModel().equals(model) || "".equals(model) || model == null)
                .filter(car -> year == null || car.getYear() == year || ("").equals(year))
                .filter(car -> car.getColor().equals(color) || "".equals(color) || color == null)
                .collect(Collectors.toList());
        return filteredCars.subList(Math.min((currPage-1)*carsPerPage, filteredCars.size()), Math.min(currPage*carsPerPage, filteredCars.size()));
    }

    public String getRandomManufacture() {
        String[] manufacturers = {"BMW", "Mercedes", "Tesla", "Gazka", "Vw", "Audi", "Opel", "Renault"};
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
        //int randomNumber = new Random().nextInt(100) + 1;
        return "" + (char) ('A' + new Random().nextInt('Z' - 'A'));

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

    public List<String> getAllModelNames() {
        return cars.stream()
                .map((c) -> c.getModel())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> getAllYears() {
        return cars.stream()
                .map((c) -> c.getYear())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllColors() {
        return cars.stream()
                .map((c) -> c.getColor())
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
