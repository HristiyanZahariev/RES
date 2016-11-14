package bg.elsys.ip.rest;

import java.awt.*;

/**
 * Created by hristiyan on 14.11.16.
 */
public class Car {

    private int id;
    private String manufacture;
    private String model;
    private String year;
    private String color;

    public Car(int id, String manufacture, String model, String year, String color) {
        this.id = id;
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }


    public String getColor() {
        return color;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public void setColor(String color) {
        this.color = color;
    }
}
