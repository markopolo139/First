package dev.mk.First.app.data.entities;

import javax.persistence.Embeddable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruckParameterEntity that = (FireTruckParameterEntity) o;
        return Objects.equals(parameter, that.parameter) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameter, value);
    }
}
