package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.interactors.EquipmentInteractor;
import dev.mk.First.web.models.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@CrossOrigin
public class EquipmentController {

    @Autowired
    private EquipmentInteractor mEquipmentInteractor;

    @GetMapping(path = "/api/v1/getEquipment")
    public Collection<EquipmentEntity> getEquipment() {

        return mEquipmentInteractor.findAll();
    }

    @PostMapping(path = "/api/v1/addEquipment")
    public void addEquipment(@Valid @RequestBody EquipmentModel equipmentModel) {

    }
}
