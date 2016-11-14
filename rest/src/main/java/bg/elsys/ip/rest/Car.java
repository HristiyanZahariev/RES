package bg.elsys.ip.rest;

import java.awt.*;

/**
 * Created by hristiyan on 14.11.16.
 */
public class Car {

    private int id;
    private Manufacture manufacture;
    private String model;
    private int year;
    private Color color;

    public Car(int id, Manufacture manufacture, String model, int year, Color color) {
        this.id = id;
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }


    public Color getColor() {
        return color;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public void setColor(Color color) {
        this.color = color;
    }
}
