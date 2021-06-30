package dev.mk.First.web.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentModel that = (EquipmentModel) o;
        return Double.compare(that.price, price) == 0
                && Objects.equals(name, that.name)
                && Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, serialNumber);
    }
}
