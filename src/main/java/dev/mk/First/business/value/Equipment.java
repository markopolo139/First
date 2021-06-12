package dev.mk.First.business.value;

import java.util.Objects;

public class Equipment {

    private String mName;
    private double mPrice;
    private String mSerialNumber;

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public String getSerialNumber() {
        return mSerialNumber;
    }

    public static class Builder {
        private Equipment mEquipment = new Equipment();

        public Builder setName(String name) {
            mEquipment.mName = name;
            return this;
        }

        public Builder setPrice(double price) {
            mEquipment.mPrice = price;
            return this;
        }

        public Builder setSerialNumber(String serialNumber) {
            mEquipment.mSerialNumber = serialNumber;
            return this;
        }

        public void validate() {
            if(mEquipment.mName.equals("")
            || mEquipment.mSerialNumber.equals("")
            || mEquipment.mPrice == 0.0)
                throw new IllegalStateException("Not all parameters specified");
        }

        public Equipment build() {
            validate();
            return mEquipment;
        }

    }

    private Equipment() {
    }

    public Equipment(String name, double price, String serialNumber) {
        mName = name;
        mPrice = price;
        mSerialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Double.compare(equipment.getPrice(), getPrice()) == 0
                && getName().equals(equipment.getName())
                && getSerialNumber().equals(equipment.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getSerialNumber());
    }
}
