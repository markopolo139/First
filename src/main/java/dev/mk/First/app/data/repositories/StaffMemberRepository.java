package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.business.value.BloodType;
import dev.mk.First.business.value.CallType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface StaffMemberRepository extends CrudRepository<StaffMemberEntity, Integer> {

    @Query(
            "select sme from StaffMemberEntity sme " +
                    "where (:firstname is null or sme.firstname = :firstname) " +
                    "and (:lastname is null or sme.lastname = :lastname) " +
                    "and (:joiningTimeStart is null or sme.joiningDate >= :joiningTimeStart) " +
                    "and (:joiningTimeEnd is null or sme.joiningDate <= :joiningTimeEnd) " +
                    "and (:pesel is null or sme.pesel = :pesel) " +
                    "and (:address is null or sme.address = :address) " +
                    "and (:city is null or sme.city = :city) " +
                    "and (:city is null or sme.city = :city) " +
                    "and (:periodicExaminationsExpiryDateStart is null " +
                    "or sme.periodicExaminationsExpiryDate >= :periodicExaminationsExpiryDateStart) " +
                    "and (:periodicExaminationsExpiryDateEnd is null " +
                    "or sme.periodicExaminationsExpiryDate <= :periodicExaminationsExpiryDateEnd) " +
                    "and (:isDriver is null or sme.isDriver = :isDriver) " +
                    "and (:birthdateStart is null or sme.birthdate >= :birthdateStart) " +
                    "and (:birthdateEnd is null or sme.birthdate <= :birthdateEnd) " +
                    "and (:bloodType is null or sme.bloodType = :bloodType) " +
                    "and (:email is null or sme.email = :email) " +
                    "and (:phoneNumber is null or sme.phoneNumber = :phoneNumber) "

    )
    List<StaffMemberEntity> findAllByFilter(
            @Param("firstname") String firstname,
            @Param("lastname") String lastname,
            @Param("joiningTimeStart") LocalDate joiningTimeStart,
            @Param("joiningTimeEnd") LocalDate joiningTimeEnd,
            @Param("pesel") String pesel,
            @Param("address") String address,
            @Param("city") String city,
            @Param("periodicExaminationsExpiryDateStart") LocalDate periodicExaminationsExpiryDateStart,
            @Param("periodicExaminationsExpiryDateEnd") LocalDate periodicExaminationsExpiryDateEnd,
            @Param("isDriver") boolean isDriver,
            @Param("birthdateStart") LocalDate birthdateStart,
            @Param("birthdateEnd") LocalDate birthdateEnd,
            @Param("bloodType") BloodType bloodType,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber
            );

}
