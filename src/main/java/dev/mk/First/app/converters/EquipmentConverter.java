package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.web.models.EquipmentModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface EquipmentConverter {

    EquipmentModel convertToModel(EquipmentEntity equipmentEntity);

    EquipmentEntity convertToEntity(EquipmentModel equipmentModel);

    Collection<EquipmentModel> convertCollectionToModel(Collection<EquipmentEntity> equipmentEntityCollection);

    Collection<EquipmentEntity> convertCollectionToEntity(Collection<EquipmentModel> equipmentModels);
}
