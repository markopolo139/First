package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.FireTruckParameterEntity;
import dev.mk.First.web.models.FireTruckParameterModel;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class FireTruckParameterConverterImpl implements FireTruckParameterConverter{

    @Override
    public FireTruckParameterModel convertToModel(FireTruckParameterEntity fireTruckParameterEntity) {
        return new FireTruckParameterModel(fireTruckParameterEntity.parameter, fireTruckParameterEntity.value);
    }

    @Override
    public FireTruckParameterEntity convertToEntity(FireTruckParameterModel fireTruckParameterModel) {
        return new FireTruckParameterEntity(fireTruckParameterModel.parameter, fireTruckParameterModel.value);
    }

    @Override
    public Collection<FireTruckParameterModel> convertCollectionToModel(
            Collection<FireTruckParameterEntity> fireTruckParameterEntities
    ) {
        return fireTruckParameterEntities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    @Override
    public Collection<FireTruckParameterEntity> convertCollectionToEntity(
            Collection<FireTruckParameterModel> fireTruckParameterModels
    ) {
        return fireTruckParameterModels.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
