package dev.mk.First.web.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Collection;
import java.util.Objects;

public class FireTruckModel {

    @NotBlank
    public String name;

    @Positive
    public double price;

    @NotBlank
    public String vin;

    @Positive
    public int productionYear;

    @NotBlank
    public String operationalNumber;

    @NotBlank
    public String type;

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

    public FireTruckModel(String name, double price, String vin, int productionYear, String operationalNumber,
                          String type, int horsepower, int numberOfSeats, int mileage,
                          Collection<FireTruckParameterModel> fireTruckParameters) {
        this.name = name;
        this.price = price;
        this.vin = vin;
        this.productionYear = productionYear;
        this.operationalNumber = operationalNumber;
        this.type = type;
        this.horsepower = horsepower;
        this.numberOfSeats = numberOfSeats;
        this.mileage = mileage;
        this.fireTruckParameters = fireTruckParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruckModel that = (FireTruckModel) o;
        return Double.compare(that.price, price) == 0
                && productionYear == that.productionYear
                && horsepower == that.horsepower
                && numberOfSeats == that.numberOfSeats
                && mileage == that.mileage
                && Objects.equals(name, that.name)
                && Objects.equals(vin, that.vin)
                && Objects.equals(operationalNumber, that.operationalNumber)
                && Objects.equals(type, that.type)
                && Objects.equals(fireTruckParameters, that.fireTruckParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name, price, vin, productionYear, operationalNumber,
                type, horsepower, numberOfSeats, mileage, fireTruckParameters
        );
    }
}
