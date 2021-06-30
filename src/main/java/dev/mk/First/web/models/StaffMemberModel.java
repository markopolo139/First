package dev.mk.First.web.models;

import dev.mk.First.business.value.BloodType;
import dev.mk.First.web.validation.ValidBloodType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class StaffMemberModel {

    @NotBlank
    public String firstname;

    @NotBlank
    public String lastname;

    @NotNull
    public LocalDate joiningDate;

    @NotBlank
    public String pesel;

    @NotBlank
    public String address;

    @NotBlank
    public String city;

    @NotNull
    public LocalDate periodicExaminationsExpiryDate;

    @NotNull
    public boolean isDriver;

    @NotNull
    public LocalDate birthdate;

    @NotNull
    @ValidBloodType
    public String bloodType;

    @NotBlank
    public String email;

    @NotBlank
    public String phoneNumber;

    @NotEmpty
    public Collection<TrainingModel> trainings;

    public StaffMemberModel() {
    }

    public StaffMemberModel(String firstname, String lastname, LocalDate joiningDate, String pesel, String address,
                            String city, LocalDate periodicExaminationsExpiryDate, boolean isDriver,
                            LocalDate birthdate, String bloodType, String email, String phoneNumber,
                            Collection<TrainingModel> trainings) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.joiningDate = joiningDate;
        this.pesel = pesel;
        this.address = address;
        this.city = city;
        this.periodicExaminationsExpiryDate = periodicExaminationsExpiryDate;
        this.isDriver = isDriver;
        this.birthdate = birthdate;
        this.bloodType = bloodType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.trainings = trainings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMemberModel that = (StaffMemberModel) o;
        return isDriver == that.isDriver
                && Objects.equals(firstname, that.firstname)
                && Objects.equals(lastname, that.lastname)
                && Objects.equals(joiningDate, that.joiningDate)
                && Objects.equals(pesel, that.pesel)
                && Objects.equals(address, that.address)
                && Objects.equals(city, that.city)
                && Objects.equals(periodicExaminationsExpiryDate, that.periodicExaminationsExpiryDate)
                && Objects.equals(birthdate, that.birthdate)
                && Objects.equals(bloodType, that.bloodType)
                && Objects.equals(email, that.email)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(trainings, that.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstname, lastname, joiningDate,
                pesel, address, city,
                periodicExaminationsExpiryDate,
                isDriver, birthdate, bloodType,
                email, phoneNumber, trainings
        );
    }
}
