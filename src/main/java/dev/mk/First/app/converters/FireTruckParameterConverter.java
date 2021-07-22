package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.FireTruckParameterEntity;
import dev.mk.First.web.models.FireTruckParameterModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

public interface FireTruckParameterConverter {

    FireTruckParameterModel convertToModel(FireTruckParameterEntity fireTruckParameterEntity);

    FireTruckParameterEntity convertToEntity(FireTruckParameterModel fireTruckParameterModel);

    Collection<FireTruckParameterModel> convertCollectionToModel(Collection<FireTruckParameterEntity> fireTruckParameterEntities);

    Collection<FireTruckParameterEntity> convertCollectionToEntity(Collection<FireTruckParameterModel> fireTruckParameterModels);

}
