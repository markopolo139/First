package dev.mk.First.app.data.entities;

import dev.mk.First.business.value.BloodType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "staff_members")
public class StaffMemberEntity {

    @Id
    @GeneratedValue
    @Column(name = "staff_member_id")
    public int staffMemberId;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "joining_date")
    public LocalDate joiningDate;

    @Column(name = "pesel")
    public String pesel;

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
    @Enumerated(EnumType.STRING)
    public BloodType bloodType;

    @Column(name = "email")
    public String email;

    @Column(name = "phone_number")
    public String phoneNumber;

    @OneToMany
    @JoinColumn(name = "training_id")
    public Collection<TrainingEntity> trainings;

    public StaffMemberEntity() {
    }

    public StaffMemberEntity(String firstname, String lastname, LocalDate joiningDate, String pesel, String address,
                             String city, LocalDate periodicExaminationsExpiryDate, boolean isDriver,
                             LocalDate birthdate, BloodType bloodType, String email, String phoneNumber,
                             Collection<TrainingEntity> trainings)
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
        this.trainings = trainings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffMemberEntity that = (StaffMemberEntity) o;
        return staffMemberId == that.staffMemberId && pesel.equals(that.pesel)
                && isDriver == that.isDriver
                && firstname.equals(that.firstname)
                && lastname.equals(that.lastname)
                && joiningDate.equals(that.joiningDate)
                && address.equals(that.address)
                && city.equals(that.city)
                && Objects.equals(periodicExaminationsExpiryDate, that.periodicExaminationsExpiryDate)
                && birthdate.equals(that.birthdate)
                && bloodType == that.bloodType
                && email.equals(that.email)
                && phoneNumber.equals(that.phoneNumber)
                && Objects.equals(trainings, that.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffMemberId, firstname, lastname, joiningDate, pesel, address, city, periodicExaminationsExpiryDate,
                isDriver, birthdate, bloodType, email, phoneNumber, trainings);
    }
}
