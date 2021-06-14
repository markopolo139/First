package dev.mk.First.app.data.entities;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FireTruckParameterEntity {

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String value;

    public FireTruckParameterEntity() {
    }

    public FireTruckParameterEntity(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

}
