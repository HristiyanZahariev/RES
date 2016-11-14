package bg.elsys.ip.rest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.awt.Color.black;

/**
 * Created by hristiyan on 14.11.16.
 */
public class GenerateData {

    private static final List<Car> cars = new ArrayList<>();

    public static List getCars() {
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(i, getRandomManufacture(), "C220", getRandomYear(),getRandomColor() ));
        }
        return cars;
    }

    public static Manufacture getRandomManufacture() {
        Manufacture[] manufcaturers = Manufacture.values();
        int idx = new Random().nextInt(manufcaturers.length); //copy pasta dis from http://stackoverflow.com/questions/13340516/random-element-from-string-array
        return manufcaturers[idx];
    }

    public static int getRandomYear() {
        Random rand = new Random();
        int year = 0;
        int maxYear = 2016;
        int minYear = 1940;
        int range = maxYear - minYear;

        return year = rand.nextInt(range) + minYear; //This will generate an year from 1940 to 2016
    }

    public static Color getRandomColor() {
        Color[] colors = Color.values();
        int idx = new Random().nextInt(colors.length);
        return colors[idx];

    }
}
