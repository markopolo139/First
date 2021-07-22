package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.interactors.CallInteractor;
import dev.mk.First.business.value.Call;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

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
}
