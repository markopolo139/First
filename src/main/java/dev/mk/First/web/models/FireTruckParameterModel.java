package dev.mk.First.web.models;

import javax.validation.constraints.NotBlank;

public class FireTruckParameterModel {

    @NotBlank
    public String key;

    @NotBlank
    public String value;

    public FireTruckParameterModel() {
    }

    public FireTruckParameterModel(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
