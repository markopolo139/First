package dev.mk.First.business.value;

import java.util.Objects;

public class TruckParameter {

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public TruckParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckParameter that = (TruckParameter) o;
        return getKey().equals(that.getKey()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}
