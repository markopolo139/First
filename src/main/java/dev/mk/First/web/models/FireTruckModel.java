package dev.mk.First.web.models;

import dev.mk.First.business.value.FireTruckParameter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Collection;

public class FireTruckModel {

    @NotBlank
    public String truckName;

    @Positive
    public double price;

    @NotBlank
    public String vin;

    @Positive
    public int productionYear;

    @NotBlank
    public String operationalNumber;

    @NotBlank
    public String truckType;

    @Positive
    public int horsepower;

    @Positive
    public int numberOfSeats;

    @Positive
    public int mileage;

    @NotEmpty
    public Collection<FireTruckParameterModel> fireTruckParameters;

    public FireTruckModel() {
    }

    public FireTruckModel(String truckName, double price, String vin, int productionYear, String operationalNumber,
                          String truckType, int horsepower, int numberOfSeats, int mileage,
                          Collection<FireTruckParameterModel> fireTruckParameters) {
        this.truckName = truckName;
        this.price = price;
        this.vin = vin;
        this.productionYear = productionYear;
        this.operationalNumber = operationalNumber;
        this.truckType = truckType;
        this.horsepower = horsepower;
        this.numberOfSeats = numberOfSeats;
        this.mileage = mileage;
        this.fireTruckParameters = fireTruckParameters;
    }
}
