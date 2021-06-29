package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.web.models.EquipmentModel;

import java.util.Collection;
import java.util.stream.Collectors;

public class EquipmentConverterImpl implements EquipmentConverter {

    @Override
    public EquipmentModel convertToModel(EquipmentEntity equipmentEntity) {
        return new EquipmentModel(equipmentEntity.name, equipmentEntity.price, equipmentEntity.serialNumber);
    }

    @Override
    public EquipmentEntity convertToEntity(EquipmentModel equipmentModel) {
        return new EquipmentEntity(equipmentModel.name, equipmentModel.price, equipmentModel.serialNumber);
    }

    @Override
    public Collection<EquipmentModel> convertCollectionToModel(Collection<EquipmentEntity> equipmentEntities) {
        return equipmentEntities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    @Override
    public Collection<EquipmentEntity> convertCollectionToEntity(Collection<EquipmentModel> equipmentModels) {
        return equipmentModels.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
