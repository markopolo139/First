package dev.mk.First.app.repository;

import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.app.data.repositories.TrainingRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TrainingRepositoryImpl implements TrainingRepository {

    private final List<TrainingEntity> mTrainingEntities = new LinkedList<>();

    @Override
    public <S extends TrainingEntity> S save(S entity) {
        mTrainingEntities.add(entity);
        return entity;
    }

    @Override
    public <S extends TrainingEntity> Iterable<S> saveAll(Iterable<S> entities) {
        mTrainingEntities.addAll((Collection<? extends TrainingEntity>) entities);
        return entities;
    }

    @Override
    public Optional<TrainingEntity> findById(Integer integer) {
        return mTrainingEntities.stream().filter(i -> i.trainingId == integer).findAny();
    }

    @Override
    public boolean existsById(Integer integer) {
        return mTrainingEntities.stream().anyMatch(i -> i.trainingId == integer);
    }

    @Override
    public Iterable<TrainingEntity> findAll() {
        return mTrainingEntities;
    }

    @Override
    public Iterable<TrainingEntity> findAllById(Iterable<Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(),false).collect(Collectors.toList());

        return mTrainingEntities.stream().filter(i -> integerList.contains(i.trainingId)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return mTrainingEntities.size();
    }

    @Override
    public void deleteById(Integer integer) {
        mTrainingEntities.removeIf(i -> i.trainingId == integer);
    }

    @Override
    public void delete(TrainingEntity entity) {
        mTrainingEntities.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(),false).collect(Collectors.toList());

        mTrainingEntities.removeIf(i -> integerList.contains(i.trainingId));
    }

    @Override
    public void deleteAll(Iterable<? extends TrainingEntity> entities) {
        for(TrainingEntity te : entities)
            mTrainingEntities.remove(te);
    }

    @Override
    public void deleteAll() {
        mTrainingEntities.clear();
    }
}
