package bg.elsys.ip.rest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.black;

/**
 * Created by hristiyan on 14.11.16.
 */
public class GenerateData {

    private static final List<Car> cars = new ArrayList<>();

    public static List getCars() {
        for (int i = 1; i <= 10; i++) {
            cars.add(new Car(i, "Benz", "C220", "2005", "blue"));
        }
        return cars;
    }
}
