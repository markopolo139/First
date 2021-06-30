package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.FireTruckConverter;
import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.app.data.repositories.FireTruckRepository;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FireTruckInteractor {

    @Autowired
    private FireTruckRepository mFireTruckRepository;

    @Autowired
    private FireTruckConverter mFireTruckConverter;

    public Collection<FireTruckEntity> findAll() {
        return mFireTruckRepository.findAll();
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
}
