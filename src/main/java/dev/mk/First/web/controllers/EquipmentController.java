package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.interactors.EquipmentInteractor;
import dev.mk.First.web.models.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Validated
@RestController
@CrossOrigin
public class EquipmentController {

    @Autowired
    private EquipmentInteractor mEquipmentInteractor;

    @GetMapping(path = "/api/v1/equipment/get")
    public Collection<EquipmentModel> getEquipment() {
        return mEquipmentInteractor.findAll();
    }

    @PostMapping(path = "/api/v1/equipment/add")
    public void addEquipment(@Valid @RequestBody EquipmentModel equipmentModel) {
        mEquipmentInteractor.saveEntity(equipmentModel);
    }

    @DeleteMapping(path = "/api/v1/equipment/deleteById")
    public void deleteEquipmentById(Integer id) {
        mEquipmentInteractor.deleteEntity(id);
    }

    @DeleteMapping(path = "/api/v1/equipment/deleteByIds")
    public void deleteEquipmentByIdCollection(Collection<Integer> id) {
        mEquipmentInteractor.deleteEntities(id);
    }

    @PatchMapping(path = "/api/v1/equipment/update")
    public void updateEquipment(Integer id, @Valid @RequestBody EquipmentModel updatedEquipment) {
        mEquipmentInteractor.updateEntity(id, updatedEquipment);
    }

    @GetMapping(path = "api/v1/equipment/filter")
    public Collection<EquipmentModel> getFilteredEquipment(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "priceStart", required = false) Double priceStart,
            @RequestParam(value = "priceEnd", required = false) Double priceEnd,
            @RequestParam(value = "serialNumber", required = false) String serialNumber
    ) {
        return mEquipmentInteractor.findFiltered(name, priceStart, priceEnd, serialNumber);
    }
}
