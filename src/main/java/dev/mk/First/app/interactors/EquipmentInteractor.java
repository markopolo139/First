package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.EquipmentConverter;
import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.data.repositories.EquipmentRepository;
import dev.mk.First.web.models.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.List;

@Service
public class EquipmentInteractor {

    @Autowired
    private EquipmentRepository mEquipmentRepository;

    @Autowired
    private EquipmentConverter mEquipmentConverter;

    public Collection<EquipmentModel> findAll() {
        return mEquipmentConverter
                .convertCollectionToModel((Collection < EquipmentEntity >) mEquipmentRepository.findAll());
    }

    public void saveEntity(EquipmentModel equipmentModel) {
        mEquipmentRepository.save(mEquipmentConverter.convertToEntity(equipmentModel));
    }

    public void deleteEntity(Integer id) {
        mEquipmentRepository.deleteById(id);
    }

    public void deleteEntities(Collection<Integer> id) {
        mEquipmentRepository.deleteAllById(id);
    }

    public void updateEntity(Integer id, EquipmentModel updatedEquipment) {

        mEquipmentRepository.deleteById(id);
        EquipmentEntity updatedEntity = mEquipmentConverter.convertToEntity(updatedEquipment);
        updatedEntity.equipmentId = id;
        mEquipmentRepository.save(updatedEntity);

    }

    public Collection<EquipmentModel> findFiltered(
            @Nullable String name,
            @Nullable Double priceStart,
            @Nullable Double priceEnd,
            @Nullable String serialNumber
    ) {
        return mEquipmentConverter.convertCollectionToModel(mEquipmentRepository.findAllByFilter(name, priceStart,
                priceEnd, serialNumber));
    }
}
