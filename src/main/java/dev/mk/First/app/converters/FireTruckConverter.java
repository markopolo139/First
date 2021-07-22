package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.business.value.FireTruck;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

public interface FireTruckConverter {

    FireTruckEntity convertToEntity(FireTruckModel fireTruckModel);

    FireTruckModel convertToModel(FireTruckEntity fireTruckEntity);

    Collection<FireTruckEntity> convertCollectionToEntity(Collection<FireTruckModel> fireTruckModels);

    Collection<FireTruckModel> convertCollectionToModel(Collection<FireTruckEntity> fireTruckEntities);
}
