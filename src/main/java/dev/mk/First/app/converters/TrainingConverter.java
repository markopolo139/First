package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.web.models.TrainingModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

public interface TrainingConverter {

    TrainingEntity convertToEntity(TrainingModel trainingModel);

    TrainingModel convertToModel(TrainingEntity trainingEntity);

    Collection<TrainingEntity> covertCollectionToEntity(Collection<TrainingModel> trainingModels);

    Collection<TrainingModel> covertCollectionToModel(Collection<TrainingEntity> trainingEntities);

}
