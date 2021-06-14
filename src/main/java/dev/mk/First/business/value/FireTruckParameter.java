package dev.mk.First.business.value;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FireTruckParameter {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public FireTruckParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruckParameter that = (FireTruckParameter) o;
        return getKey().equals(that.getKey()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}
