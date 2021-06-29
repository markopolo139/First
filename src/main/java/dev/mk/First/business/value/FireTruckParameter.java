package dev.mk.First.business.value;

import java.util.Objects;

public class FireTruckParameter {

    private String parameter;
    private String value;

    public String getParameter() {
        return parameter;
    }

    public String getValue() {
        return value;
    }

    public FireTruckParameter(String key, String value) {
        this.parameter = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruckParameter that = (FireTruckParameter) o;
        return getParameter().equals(that.getParameter()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParameter(), getValue());
    }
}
