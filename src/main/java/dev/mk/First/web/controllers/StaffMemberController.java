package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.interactors.StaffMemberInteractor;
import dev.mk.First.business.value.BloodType;
import dev.mk.First.business.value.CallType;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.StaffMemberModel;
import dev.mk.First.web.validation.ValidCallTypeWithNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Validated
@RestController
@CrossOrigin
public class StaffMemberController {
    
    @Autowired
    private StaffMemberInteractor mStaffMemberInteractor;

    @GetMapping(path = "/api/v1/staffMember/get")
    public Collection<StaffMemberModel> getStaffMember() {
        return mStaffMemberInteractor.findAll();
    }

    @PostMapping(path = "/api/v1/staffMember/add")
    public void addStaffMember(@Valid @RequestBody StaffMemberModel staffMemberModel) {
        mStaffMemberInteractor.saveEntity(staffMemberModel);
    }

    @DeleteMapping(path = "/api/v1/staffMember/deleteById")
    public void deleteStaffMemberById(Integer id) {
        mStaffMemberInteractor.deleteEntity(id);
    }

    @DeleteMapping(path = "/api/v1/staffMember/deleteByIds")
    public void deleteStaffMemberByIdCollection(Collection<Integer> id) {
        mStaffMemberInteractor.deleteEntities(id);
    }

    @PatchMapping(path = "/api/v1/staffMember/update")
    public void updateStaffMember(Integer id, @Valid @RequestBody StaffMemberModel updatedStaffMember) {
        mStaffMemberInteractor.updateEntity(id,updatedStaffMember);
    }

    @GetMapping(path = "/api/v1/staffMember/filter")
    public Collection<StaffMemberModel> getFilteredStaffMembers(
            @RequestParam(value = "firstname", required = false) String firstname,
            @RequestParam(value = "lastname", required = false) String lastname,
            @RequestParam(value = "joiningTimeStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate joiningTimeStart,
            @RequestParam(name = "joiningTimeEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate joiningTimeEnd,
            @RequestParam(value = "pesel", required = false) String pesel,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "periodicExaminationsExpiryDateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodicExaminationsExpiryDateStart,
            @RequestParam(name = "periodicExaminationsExpiryDateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodicExaminationsExpiryDateEnd,
            @RequestParam(value = "isDriver", required = false) Boolean isDriver,
            @RequestParam(value = "birthdateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdateStart,
            @RequestParam(name = "birthdateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdateEnd,
            @RequestParam(value = "bloodType", required = false) @ValidCallTypeWithNull String bloodType,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber
    ) {

        BloodType bt = bloodType == null ? null : BloodType.valueOf(bloodType);

        return mStaffMemberInteractor.findFiltered(
                firstname, lastname, joiningTimeStart, joiningTimeEnd, pesel, address, city,
                periodicExaminationsExpiryDateStart, periodicExaminationsExpiryDateEnd, isDriver,
                birthdateStart, birthdateEnd, bt , email, phoneNumber
        );
    }
}
