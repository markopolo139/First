package dev.mk.First.business.value;

import java.util.Collection;
import java.util.Objects;

public class FireTruck {

    private String mTruckName;
    private double mPrice;
    private String mVin;
    private int mProductionYear;
    private String mOperationalNumber;
    private String mTruckType;
    private int mHorsepower;
    private int mNumberOfSeats;
    private int mMileage;
    private Collection<FireTruckParameter> mFireTruckParameters;

    public static Builder builder() {
        return new Builder();
    }

    public String getTruckName() {
        return mTruckName;
    }

    public double getPrice() {
        return mPrice;
    }

    public String getVin() {
        return mVin;
    }

    public int getProductionYear() {
        return mProductionYear;
    }

    public String getOperationalNumber() {
        return mOperationalNumber;
    }

    public String getTruckType() {
        return mTruckType;
    }

    public int getHorsepower() {
        return mHorsepower;
    }

    public int getNumberOfSeats() {
        return mNumberOfSeats;
    }

    public int getMileage() {
        return mMileage;
    }

    public Collection<FireTruckParameter> getTruckParameters() {
        return mFireTruckParameters;
    }

    public static class Builder {

        private FireTruck mFireTruck = new FireTruck();

        public Builder setTruckName(String truckName) {
            mFireTruck.mTruckName = truckName;
            return this;
        }

        public Builder setPrice(double price) {
            mFireTruck.mPrice = price;
            return this;
        }

        public Builder setVin(String vin) {
            mFireTruck.mVin = vin;
            return this;
        }

        public Builder setProductionYear(int productionYear) {
           mFireTruck. mProductionYear = productionYear;
           return this;
        }

        public Builder setOperationalNumber(String operationalNumber) {
            mFireTruck.mOperationalNumber = operationalNumber;
            return this;
        }

        public Builder setTruckType(String truckType) {
            mFireTruck.mTruckType = truckType;
            return this;
        }

        public Builder setHorsepower(int horsepower) {
            mFireTruck.mHorsepower = horsepower;
            return this;
        }

        public Builder setNumberOfSeats(int numberOfSeats) {
            mFireTruck.mNumberOfSeats = numberOfSeats;
            return this;
        }

        public Builder setMileage(int mileage) {
            mFireTruck.mMileage = mileage;
            return this;
        }

        public Builder setTruckParameters(Collection<FireTruckParameter> fireTruckParameters) {
            mFireTruck.mFireTruckParameters = fireTruckParameters;
            return this;
        }

        public void validate() {
            if(mFireTruck.mTruckName.equals("")
                    || mFireTruck.mTruckType.equals("")
                    || mFireTruck.mHorsepower == 0
                    || mFireTruck.mNumberOfSeats == 0
                    || mFireTruck.mOperationalNumber.equals("")
                    || mFireTruck.mPrice == 0
                    || mFireTruck.mProductionYear == 0
                    || mFireTruck.mVin.equals("")
            )
                throw new IllegalStateException("Not all parameters specified");
        }

        public FireTruck build() {
            validate();
            return mFireTruck;
        }

    }

    private FireTruck() {}

    public FireTruck(
            String truckName, double price, String vin, int productionYear, String operationalNumber, String truckType,
            int horsepower, int numberOfSeats, int mileage, Collection<FireTruckParameter> fireTruckParameters
    )
    {
        mTruckName = truckName;
        mPrice = price;
        mVin = vin;
        mProductionYear = productionYear;
        mOperationalNumber = operationalNumber;
        mTruckType = truckType;
        mHorsepower = horsepower;
        mNumberOfSeats = numberOfSeats;
        mMileage = mileage;
        mFireTruckParameters = fireTruckParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireTruck fireTruck = (FireTruck) o;
        return Double.compare(
                fireTruck.getPrice(), getPrice()) == 0
                && getProductionYear() == fireTruck.getProductionYear()
                && getHorsepower() == fireTruck.getHorsepower()
                && getNumberOfSeats() == fireTruck.getNumberOfSeats()
                && getMileage() == fireTruck.getMileage()
                && getTruckName().equals(fireTruck.getTruckName())
                && getVin().equals(fireTruck.getVin())
                && getOperationalNumber().equals(fireTruck.getOperationalNumber())
                && getTruckType().equals(fireTruck.getTruckType())
                && getTruckParameters().equals(fireTruck.getTruckParameters()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getTruckName(), getPrice(), getVin(), getProductionYear(), getOperationalNumber(), getTruckType(),
                getHorsepower(), getNumberOfSeats(), getMileage(), getTruckParameters()
        );
    }
}
