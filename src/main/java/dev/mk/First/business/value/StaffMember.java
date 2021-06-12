package dev.mk.First.business.value;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class StaffMember {

    private String mFirstname;
    private String mLastname;
    private LocalDate mJoiningDate;
    private final int mPesel;
    private String mAddress;
    private String mCity;
    private LocalDate mPeriodicExaminationsExpiryDate;
    private boolean mIsDriver;
    private LocalDate mBirthdate;
    private BloodType mBloodType;
    private String mEmail;
    private String mPhoneNumber;
    private Collection<Training> mTrainings;

    public String getFirstname() {
        return mFirstname;
    }

    public String getLastname() {
        return mLastname;
    }

    public LocalDate getJoiningDate() {
        return mJoiningDate;
    }

    public int getPesel() {
        return mPesel;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getCity() {
        return mCity;
    }

    public LocalDate getPeriodicExaminationsExpiryDate() {
        return mPeriodicExaminationsExpiryDate;
    }

    public boolean isDriver() {
        return mIsDriver;
    }

    public LocalDate getBirthdate() {
        return mBirthdate;
    }

    public BloodType getBloodType() {
        return mBloodType;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public Collection<Training> getTrainings() {
        return mTrainings;
    }

    public StaffMember(String firstname, String lastname, LocalDate joiningDate, int pesel, String address, String city,
                       LocalDate periodicExaminationsExpiryDate, boolean isDriver, LocalDate birthdate,
                       BloodType bloodType, String email, String phoneNumber, Collection<Training> trainings) {
        mFirstname = firstname;
        mLastname = lastname;
        mJoiningDate = joiningDate;
        mPesel = pesel;
        mAddress = address;
        mCity = city;
        mPeriodicExaminationsExpiryDate = periodicExaminationsExpiryDate;
        mIsDriver = isDriver;
        mBirthdate = birthdate;
        mBloodType = bloodType;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mTrainings = trainings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMember that = (StaffMember) o;
        return getPesel() == that.getPesel() && isDriver() == that.isDriver()
                && Objects.equals(getFirstname(), that.getFirstname())
                && Objects.equals(getLastname(), that.getLastname())
                && Objects.equals(getJoiningDate(), that.getJoiningDate())
                && Objects.equals(getAddress(), that.getAddress())
                && Objects.equals(getCity(), that.getCity())
                && Objects.equals(getPeriodicExaminationsExpiryDate(), that.getPeriodicExaminationsExpiryDate())
                && Objects.equals(getBirthdate(), that.getBirthdate())
                && getBloodType() == that.getBloodType()
                && Objects.equals(getEmail(), that.getEmail())
                && Objects.equals(getPhoneNumber(), that.getPhoneNumber())
                && Objects.equals(getTrainings(), that.getTrainings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getJoiningDate(), getPesel(), getAddress(), getCity(),
                getPeriodicExaminationsExpiryDate(), isDriver(), getBirthdate(), getBloodType(), getEmail(),
                getPhoneNumber(), getTrainings());
    }
}
