package dev.mk.First.web.models;

import javax.validation.constraints.NotBlank;

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
}
