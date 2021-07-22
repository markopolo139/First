package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.interactors.CallInteractor;
import dev.mk.First.business.value.Call;
import dev.mk.First.business.value.CallType;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.EquipmentModel;
import dev.mk.First.web.validation.ValidCallType;
import dev.mk.First.web.validation.ValidCallTypeWithNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Collection;

@Validated
@RestController
@CrossOrigin
public class CallController {

    @Autowired
    private CallInteractor mCallInteractor;

    @GetMapping(path = "/api/v1/call/get")
    public Collection<CallModel> getCall() {
        return mCallInteractor.findAll();
    }

    @PostMapping(path = "/api/v1/call/add")
    public void addCall(@Valid @RequestBody CallModel callModel) {
        mCallInteractor.saveEntity(callModel);
    }

    @DeleteMapping(path = "/api/v1/call/deleteById")
    public void deleteCallById(Integer id) {
        mCallInteractor.deleteEntity(id);
    }

    @DeleteMapping(path = "/api/v1/call/deleteByIds")
    public void deleteCallByIdCollection(Collection<Integer> id) {
        mCallInteractor.deleteEntities(id);
    }

    @PatchMapping(path = "/api/v1/call/update")
    public void updateCall(Integer id, @Valid @RequestBody CallModel updatedCall) {
        mCallInteractor.updateEntity(id,updatedCall);
    }

    @GetMapping(path = "/api/v1/call/filter")
    public Collection<CallModel> getFilteredCalls(
            @RequestParam(value = "startDateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateStart,
            @RequestParam(name = "startDateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateEnd,
            @RequestParam(value = "endDateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateStart,
            @RequestParam(name = "endDateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateEnd,
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "details", required = false) String details,
            @RequestParam(value = "callType", required = false) @ValidCallTypeWithNull String callType
    ) {
        return mCallInteractor.findFiltered(
            startDateStart,startDateEnd,endDateStart,endDateEnd,location,details, CallType.valueOf(callType)
        );
    }
}
