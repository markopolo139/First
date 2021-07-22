package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.app.interactors.FireTruckInteractor;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Validated
@RestController
@CrossOrigin
public class FireTruckController {

    @Autowired
    private FireTruckInteractor mFireTruckInteractor;

    @GetMapping(path = "/api/v1/fireTruck/get")
    public Collection<FireTruckModel> getFireTruck() {
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

    @GetMapping(path = "api/v1/fireTruck/filter")
    public Collection<FireTruckModel> getFilteredFireTrucks(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "priceStart", required = false) Double priceStart,
            @RequestParam(value = "priceEnd", required = false) Double priceEnd,
            @RequestParam(value = "vin", required = false) String vin,
            @RequestParam(value = "productionYearStart", required = false) Integer productionYearStart,
            @RequestParam(value = "productionYearEnd", required = false) Integer productionYearEnd,
            @RequestParam(value = "operationalNumbers", required = false) String operationalNumbers,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "horsepowerStart", required = false) Integer horsepowerStart,
            @RequestParam(value = "horsepowerEnd", required = false) Integer horsepowerEnd,
            @RequestParam(value = "numberOfSeatsStart", required = false) Integer numberOfSeatsStart,
            @RequestParam(value = "numberOfSeatsEnd", required = false) Integer numberOfSeatsEnd,
            @RequestParam(value = "mileageStart", required = false) Integer mileageStart,
            @RequestParam(value = "mileageEnd", required = false) Integer mileageEnd
    ) {
        return mFireTruckInteractor.findFiltered(name, priceStart,
                priceEnd, vin, productionYearStart, productionYearEnd, operationalNumbers, type, horsepowerStart,
                horsepowerEnd, numberOfSeatsStart, numberOfSeatsEnd, mileageStart, mileageEnd);
    }
}
