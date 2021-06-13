package dev.mk.First.app.data.entities;

import dev.mk.First.business.value.BloodType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "staff_members")
public class StaffMemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "staff_member_id")
    public int id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "joining_date")
    public LocalDate joiningDate;

    @Column(name = "pesel")
    public int pesel;

    @Column(name = "address")
    public String address;

    @Column(name = "city")
    public String city;

    @Column(name = "periodic_examinations_expiry_date")
    public LocalDate periodicExaminationsExpiryDate;

    @Column(name = "is_driver")
    public boolean isDriver;

    @Column(name = "birthdate")
    public LocalDate birthdate;

    @Column(name = "blood_type")
    public BloodType bloodType;

    @Column(name = "email")
    public String email;

    @Column(name = "phone_number")
    public String phoneNumber;

    public StaffMemberEntity() {
    }

    public StaffMemberEntity(String firstname, String lastname, LocalDate joiningDate, int pesel, String address,
                             String city, LocalDate periodicExaminationsExpiryDate, boolean isDriver,
                             LocalDate birthdate, BloodType bloodType, String email, String phoneNumber)
    {
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMemberEntity that = (StaffMemberEntity) o;
        return id == that.id && pesel == that.pesel && isDriver == that.isDriver
                && Objects.equals(firstname, that.firstname)
                && Objects.equals(lastname, that.lastname)
                && Objects.equals(joiningDate, that.joiningDate)
                && Objects.equals(address, that.address)
                && Objects.equals(city, that.city)
                && Objects.equals(periodicExaminationsExpiryDate, that.periodicExaminationsExpiryDate)
                && Objects.equals(birthdate, that.birthdate)
                && bloodType == that.bloodType
                && Objects.equals(email, that.email)
                && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, joiningDate, pesel, address, city, periodicExaminationsExpiryDate,
                isDriver, birthdate, bloodType, email, phoneNumber);
    }
}
