package dev.mk.First.app.repository;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.repositories.CallRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CallsRepositoryImpl implements CallRepository {

    private final List<CallEntity> mCallEntities = new LinkedList<>();

    @Override
    public <S extends CallEntity> S save(S entity) {
        mCallEntities.add(entity);
        return entity;
    }

    @Override
    public <S extends CallEntity> Iterable<S> saveAll(Iterable<S> entities) {
        mCallEntities.addAll((Collection<? extends CallEntity>) entities);
        return entities;
    }

    @Override
    public Optional<CallEntity> findById(Integer integer) {
        return mCallEntities.stream().filter(i -> i.callId == integer).findAny();
    }

    @Override
    public boolean existsById(Integer integer) {
        return mCallEntities.stream().anyMatch(i -> i.callId == integer);
    }

    @Override
    public Iterable<CallEntity> findAll() {
        return mCallEntities;
    }

    @Override
    public Iterable<CallEntity> findAllById(Iterable<Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(),false).collect(Collectors.toList());

        return mCallEntities.stream().filter(i -> integerList.contains(i.callId)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return mCallEntities.size();
    }

    @Override
    public void deleteById(Integer integer) {
        mCallEntities.removeIf(i -> i.callId == integer);
    }

    @Override
    public void delete(CallEntity entity) {
        mCallEntities.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(),false).collect(Collectors.toList());

        mCallEntities.removeIf(i -> integerList.contains(i.callId));
    }

    @Override
    public void deleteAll(Iterable<? extends CallEntity> entities) {
        for(CallEntity ce : entities)
            mCallEntities.remove(ce);
    }

    @Override
    public void deleteAll() {
        mCallEntities.clear();
    }
}
