package kapparov.murat.springProject.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Car {
    private int id;
    @NotEmpty
    @Size(min = 2 , max = 30 , message = "too short or too long")
    private String brand;
    @NotEmpty
    @Size(min = 2 , max = 30 , message = "too short or too long")
    private String model;
    @Positive
    @Min(value = 0 , message = "negative?")
    private Integer year;
    @NotEmpty
    @Size(min = 2 , max = 30 , message = "too short or too long")
    private String type;
    @NotEmpty
    @Size(min = 2 , max = 30 , message = "too short or too long")
    private String drive_type;
    @Positive
    @Min(value = 0 , message = "negative?")
    private Integer mileage;
    @NotEmpty
    @Size(min = 2 , max = 30 , message = "too short or too long")
    private String color;
    @Positive
    @Min(value = 0 , message = "negative?")
    private Double engine_liter;
    @Positive
    @Min(value = 0 , message = "negative?")
    private Integer price;
    public Car(){
    }
    public Car(int id , String brand, String model, String engine, Integer year, String type, String drive_type, Integer mileage, String color, Double engine_liter, Integer price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.type = type;
        this.drive_type = drive_type;
        this.mileage = mileage;
        this.color = color;
        this.engine_liter = engine_liter;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDrive_type() {
        return drive_type;
    }

    public void setDrive_type(String drive_type) {
        this.drive_type = drive_type;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getEngine_liter() {
        return engine_liter;
    }

    public void setEngine_liter(Double engine_liter) {
        this.engine_liter = engine_liter;
    }
}
