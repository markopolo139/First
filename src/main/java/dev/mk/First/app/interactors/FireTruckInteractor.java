package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.FireTruckConverter;
import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.app.data.repositories.FireTruckRepository;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FireTruckInteractor {

    @Autowired
    private FireTruckRepository mFireTruckRepository;

    @Autowired
    private FireTruckConverter mFireTruckConverter;

    public Collection<FireTruckModel> findAll() {
        return mFireTruckConverter
                .convertCollectionToModel((Collection < FireTruckEntity >) mFireTruckRepository.findAll());
    }

    public void saveEntity(FireTruckModel fireTruckModel) {
        mFireTruckRepository.save(mFireTruckConverter.convertToEntity(fireTruckModel));
    }

    public void deleteEntity(Integer id) {
        mFireTruckRepository.deleteById(id);
    }

    public void deleteEntities(Collection<Integer> id) {
        mFireTruckRepository.deleteAllById(id);
    }

    public void updateEntity(Integer id, FireTruckModel updatedFireTruck) {

        mFireTruckRepository.deleteById(id);
        FireTruckEntity updatedEntity = mFireTruckConverter.convertToEntity(updatedFireTruck);
        updatedEntity.fireTruckId = id;
        mFireTruckRepository.save(updatedEntity);

    }

    public Collection<FireTruckModel> findFiltered(
            @Nullable String name,
            @Nullable Double priceStart,
            @Nullable Double priceEnd,
            @Nullable String vin,
            @Nullable Integer productionYearStart,
            @Nullable Integer productionYearEnd,
            @Nullable String operationalNumbers,
            @Nullable String type,
            @Nullable Integer horsepowerStart,
            @Nullable Integer horsepowerEnd,
            @Nullable Integer numberOfSeatsStart,
            @Nullable Integer numberOfSeatsEnd,
            @Nullable Integer mileageStart,
            @Nullable Integer mileageEnd
    ) {
        return mFireTruckConverter.convertCollectionToModel(mFireTruckRepository.findAllByFilter(name, priceStart,
                priceEnd, vin, productionYearStart, productionYearEnd, operationalNumbers, type, horsepowerStart,
                horsepowerEnd, numberOfSeatsStart, numberOfSeatsEnd, mileageStart, mileageEnd));
    }
}
