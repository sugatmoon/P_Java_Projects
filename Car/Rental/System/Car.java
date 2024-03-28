package Car.Rental.System;
public class Car {
    private String CarId;
    private String Brand;
    private String modal;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String modal, double basePricePerDay, boolean isAvailable) {
        CarId = carId;
        Brand = brand;
        this.modal = modal;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = isAvailable;
    }

    public String getCarId() {
        return CarId;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModal() {
        return modal;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}