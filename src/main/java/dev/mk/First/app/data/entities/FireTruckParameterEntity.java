package dev.mk.First.app.data.entities;

import javax.persistence.Embeddable;
@Embeddable
public class FireTruckParameterEntity {

    public String parameter;

    public String value;

    public FireTruckParameterEntity() {
    }

    public FireTruckParameterEntity(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

}
