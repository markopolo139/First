package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.business.value.FireTruck;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface FireTruckConverter {

    FireTruckEntity convertToEntity(FireTruckModel fireTruckModel);

    FireTruckModel convertToModel(FireTruckEntity fireTruckEntity);

    Collection<FireTruckEntity> convertListToEntity(Collection<FireTruckModel> fireTruckModelCollection);

    Collection<FireTruckModel> convertListToModel(Collection<FireTruckEntity> fireTruckEntities);
}
