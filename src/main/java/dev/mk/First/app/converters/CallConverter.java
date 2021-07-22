package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.web.models.CallModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

public interface CallConverter {

    CallEntity convertToEntity(CallModel callModel);

    CallModel convertToModel(CallEntity callEntity);

    Collection<CallEntity> convertCollectionToEntity(Collection<CallModel> callModels);

    Collection<CallModel> convertCollectionToModel(Collection<CallEntity> callEntities);
}
