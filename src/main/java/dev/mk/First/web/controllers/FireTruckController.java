package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.app.interactors.FireTruckInteractor;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@CrossOrigin
public class FireTruckController {

    @Autowired
    private FireTruckInteractor mFireTruckInteractor;

    @GetMapping(path = "/api/v1/fireTruck/get")
    public Collection<FireTruckEntity> getFireTruck() {
        return mFireTruckInteractor.findAll();
    }

    @PostMapping(path = "/api/v1/fireTruck/add")
    public void addFireTruck(@Valid @RequestBody FireTruckModel fireTruckModel) {
        mFireTruckInteractor.saveEntity(fireTruckModel);
    }

    @DeleteMapping(path = "/api/v1/fireTruck/deleteById")
    public void deleteFireTruckById(Integer id) {
        mFireTruckInteractor.deleteEntity(id);
    }

    @DeleteMapping(path = "/api/v1/fireTruck/deleteByIds")
    public void deleteFireTruckByIdCollection(Collection<Integer> id) {
        mFireTruckInteractor.deleteEntities(id);
    }

    @PatchMapping(path = "/api/v1/fireTruck/update")
    public void updateFireTruck(Integer id, @Valid @RequestBody FireTruckModel updatedFireTruck) {
        mFireTruckInteractor.updateEntity(id,updatedFireTruck);
    }
}
