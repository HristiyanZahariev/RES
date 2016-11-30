package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.awt.*;

/**
 * Created by hristiyan on 14.11.16.
 */
@ApiModel
public class Car {

    @ApiModelProperty(value = "Shows id for every car", example = "1")

    private int id;
    private String manufacture;
    private String model;
    private int year;
    private String color;
    static int idCounter = 1;


    public Car(String manufacture, String model, int year, String color) {
        this();
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Car() {
        id = idCounter++;
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

    public int getYear() {
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

    public void setYear(int year) {
        this.year = year;
    }


    public void setColor(String color) {
        this.color = color;
    }
}

