package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.interactors.StaffMemberInteractor;
import dev.mk.First.web.models.StaffMemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

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
}
