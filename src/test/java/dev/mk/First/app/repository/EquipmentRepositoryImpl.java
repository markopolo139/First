package dev.mk.First.app.repository;

import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.data.repositories.EquipmentRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class EquipmentRepositoryImpl implements EquipmentRepository {

    private final List<EquipmentEntity> mEquipmentEntities = new LinkedList<>();

    @Override
    public <S extends EquipmentEntity> S save(S entity) {
        mEquipmentEntities.add(entity);
        return entity;
    }

    @Override
    public <S extends EquipmentEntity> Iterable<S> saveAll(Iterable<S> entities) {
        mEquipmentEntities.addAll((Collection<? extends EquipmentEntity>) entities);
        return entities;
    }

    @Override
    public Optional<EquipmentEntity> findById(Integer integer) {
        return mEquipmentEntities.stream().filter(i -> i.equipmentId == integer).findAny();
    }

    @Override
    public boolean existsById(Integer integer) {
        return mEquipmentEntities.stream().anyMatch(i -> i.equipmentId == integer);
    }

    @Override
    public Iterable<EquipmentEntity> findAll() {
        return mEquipmentEntities;
    }

    @Override
    public Iterable<EquipmentEntity> findAllById(Iterable<Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(), false).collect(Collectors.toList());

        return mEquipmentEntities.stream().filter(i -> integerList.contains(i.equipmentId)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return mEquipmentEntities.size();
    }

    @Override
    public void deleteById(Integer integer) {
        mEquipmentEntities.removeIf(i -> i.equipmentId == integer);
    }

    @Override
    public void delete(EquipmentEntity entity) {
        mEquipmentEntities.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(), false).collect(Collectors.toList());

        mEquipmentEntities.removeIf(i -> integerList.contains(i.equipmentId));
    }

    @Override
    public void deleteAll(Iterable<? extends EquipmentEntity> entities) {
        for (EquipmentEntity eE : entities)
            mEquipmentEntities.remove(eE);
    }

    @Override
    public void deleteAll() {
        mEquipmentEntities.clear();
    }
}
