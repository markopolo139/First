package dev.mk.First.app.repository;

import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.repositories.StaffMemberRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class StaffMemberRepositoryImpl implements StaffMemberRepository {

    private final List<StaffMemberEntity> mStaffMemberEntities = new LinkedList<>();

    @Override
    public <S extends StaffMemberEntity> S save(S entity) {
        mStaffMemberEntities.add(entity);
        return entity;
    }

    @Override
    public <S extends StaffMemberEntity> Iterable<S> saveAll(Iterable<S> entities) {
        mStaffMemberEntities.addAll((Collection<? extends StaffMemberEntity>) entities);
        return entities;
    }

    @Override
    public Optional<StaffMemberEntity> findById(Integer integer) {
        return mStaffMemberEntities.stream().filter(i -> i.staffMemberId == integer).findAny();
    }

    @Override
    public boolean existsById(Integer integer) {
        return mStaffMemberEntities.stream().anyMatch(i -> i.staffMemberId == integer);
    }

    @Override
    public Iterable<StaffMemberEntity> findAll() {
        return mStaffMemberEntities;
    }

    @Override
    public Iterable<StaffMemberEntity> findAllById(Iterable<Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(), false).collect(Collectors.toList());

        return mStaffMemberEntities.stream()
                .filter(i -> integerList.contains(i.staffMemberId))
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return mStaffMemberEntities.size();
    }

    @Override
    public void deleteById(Integer integer) {
        mStaffMemberEntities.removeIf(i -> i.staffMemberId == integer);
    }

    @Override
    public void delete(StaffMemberEntity entity) {
        mStaffMemberEntities.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(), false).collect(Collectors.toList());

        mStaffMemberEntities.removeIf(i -> integerList.contains(i.staffMemberId));
    }

    @Override
    public void deleteAll(Iterable<? extends StaffMemberEntity> entities) {
        for (StaffMemberEntity smE : entities)
            mStaffMemberEntities.remove(smE);
    }

    @Override
    public void deleteAll() {
        mStaffMemberEntities.clear();
    }
}
