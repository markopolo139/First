package dev.mk.First.web.models;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class FireTruckParameterModel {

    @NotBlank
    public String parameter;

    @NotBlank
    public String value;

    public FireTruckParameterModel() {
    }

    public FireTruckParameterModel(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruckParameterModel that = (FireTruckParameterModel) o;
        return Objects.equals(parameter, that.parameter) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameter, value);
    }
}
