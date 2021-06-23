package dev.mk.First.web.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class EquipmentModel {

    @NotBlank
    public String name;

    @Positive
    public double price;

    @NotBlank
    public String serialNumber;

    public EquipmentModel() {
    }

    public EquipmentModel(String name, double price, String serialNumber) {
        this.name = name;
        this.price = price;
        this.serialNumber = serialNumber;
    }
}
