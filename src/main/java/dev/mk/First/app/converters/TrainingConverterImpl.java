package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.business.value.TrainingType;
import dev.mk.First.web.models.TrainingModel;

import java.util.Collection;
import java.util.stream.Collectors;

public class TrainingConverterImpl implements TrainingConverter {

    @Override
    public TrainingEntity convertToEntity(TrainingModel trainingModel) {
        return new TrainingEntity(
                trainingModel.trainingDate,
                trainingModel.expirationDate,
                TrainingType.valueOf(trainingModel.trainingType)
        );
    }

    @Override
    public TrainingModel convertToModel(TrainingEntity trainingEntity) {
        return new TrainingModel(
                trainingEntity.trainingDate,
                trainingEntity.expirationDate,
                trainingEntity.trainingType.name()
        );
    }

    @Override
    public Collection<TrainingEntity> covertCollectionToEntity(Collection<TrainingModel> trainingModels) {
        return trainingModels.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<TrainingModel> covertCollectionToModel(Collection<TrainingEntity> trainingEntities) {
        return trainingEntities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

}
