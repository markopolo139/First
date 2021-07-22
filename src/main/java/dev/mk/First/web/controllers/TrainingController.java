package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.app.interactors.StaffMemberInteractor;
import dev.mk.First.app.interactors.TrainingInteractor;
import dev.mk.First.web.models.StaffMemberModel;
import dev.mk.First.web.models.TrainingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
public class TrainingController {

    @Autowired
    private TrainingInteractor mTrainingInteractor;

    @GetMapping(path = "/api/v1/training/get")
    public Collection<TrainingModel> getTraining() {
        return mTrainingInteractor.findAll();
    }

    @PostMapping(path = "/api/v1/training/add")
    public void addStaffMember(@Valid @RequestBody TrainingModel trainingModel) {
        mTrainingInteractor.saveEntity(trainingModel);
    }

    @DeleteMapping(path = "/api/v1/training/deleteById")
    public void deleteStaffMemberById(Integer id) {
        mTrainingInteractor.deleteEntity(id);
    }

    @DeleteMapping(path = "/api/v1/training/deleteByIds")
    public void deleteStaffMemberByIdCollection(Collection<Integer> id) {
        mTrainingInteractor.deleteEntities(id);
    }

    @PatchMapping(path = "/api/v1/training/update")
    public void updateStaffMember(Integer id, @Valid @RequestBody TrainingModel updatedStaffMember) {
        mTrainingInteractor.updateEntity(id,updatedStaffMember);
    }

}
