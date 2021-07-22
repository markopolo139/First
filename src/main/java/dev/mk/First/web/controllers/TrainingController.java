package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.app.interactors.StaffMemberInteractor;
import dev.mk.First.app.interactors.TrainingInteractor;
import dev.mk.First.business.value.CallType;
import dev.mk.First.business.value.TrainingType;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.StaffMemberModel;
import dev.mk.First.web.models.TrainingModel;
import dev.mk.First.web.validation.ValidCallTypeWithNull;
import dev.mk.First.web.validation.ValidTrainingTypeWithNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Validated
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

    @GetMapping(path = "/api/v1/training/filter")
    public Collection<TrainingModel> getFilteredCalls(
            @RequestParam(value = "trainingDateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate trainingDateStart,
            @RequestParam(name = "trainingDateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate trainingDateEnd,
            @RequestParam(value = "expirationDateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDateStart,
            @RequestParam(name = "expirationDateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDateEnd,
            @RequestParam(value = "trainingType", required = false) @ValidTrainingTypeWithNull String trainingType
    ) {

        TrainingType tt = trainingType == null ? null : TrainingType.valueOf(trainingType);

        return mTrainingInteractor.findFiltered(
                trainingDateStart, trainingDateEnd, expirationDateStart, expirationDateEnd, tt
        );
    }

}
