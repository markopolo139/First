package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.TrainingConverter;
import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.app.data.repositories.TrainingRepository;
import dev.mk.First.web.models.TrainingModel;
import dev.mk.First.web.models.TrainingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TrainingInteractor {
    
    @Autowired
    private TrainingRepository mTrainingRepository;
    
    @Autowired
    private TrainingConverter mTrainingConverter;

    public Collection<TrainingEntity> findAll() {
        return (Collection<TrainingEntity>) mTrainingRepository.findAll();
    }

    public void saveEntity(TrainingModel trainingModel) {
        mTrainingRepository.save(mTrainingConverter.convertToEntity(trainingModel));
    }

    public void deleteEntity(Integer id) {
        mTrainingRepository.deleteById(id);
    }

    public void deleteEntities(Collection<Integer> id) {
        mTrainingRepository.deleteAllById(id);
    }

    public void updateEntity(Integer id, TrainingModel updatedTraining) {

        mTrainingRepository.deleteById(id);
        TrainingEntity updatedEntity = mTrainingConverter.convertToEntity(updatedTraining);
        updatedEntity.trainingId = id;
        mTrainingRepository.save(updatedEntity);

    }
    
}
