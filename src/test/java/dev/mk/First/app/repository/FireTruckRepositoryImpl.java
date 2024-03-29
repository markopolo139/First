package dev.mk.First.app.repository;

import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.app.data.repositories.FireTruckRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class FireTruckRepositoryImpl implements FireTruckRepository {

    private final List<FireTruckEntity> mFireTruckEntities = new LinkedList<>();

    @Override
    public <S extends FireTruckEntity> S save(S entity) {
        mFireTruckEntities.add(entity);
        return entity;
    }

    @Override
    public <S extends FireTruckEntity> Iterable<S> saveAll(Iterable<S> entities) {
        mFireTruckEntities.addAll((Collection<? extends FireTruckEntity>) entities);
        return entities;
    }

    @Override
    public Optional<FireTruckEntity> findById(Integer integer) {
        return mFireTruckEntities.stream().filter(i -> i.fireTruckId == integer).findAny();
    }

    @Override
    public boolean existsById(Integer integer) {
        return mFireTruckEntities.stream().anyMatch(i -> i.fireTruckId == integer);
    }

    @Override
    public Iterable<FireTruckEntity> findAll() {
        return mFireTruckEntities;
    }

    @Override
    public Iterable<FireTruckEntity> findAllById(Iterable<Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(),false).collect(Collectors.toList());

        return mFireTruckEntities.stream().filter(i -> integerList.contains(i.fireTruckId)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return mFireTruckEntities.size();
    }

    @Override
    public void deleteById(Integer integer) {
        mFireTruckEntities.removeIf(i -> i.fireTruckId == integer);
    }

    @Override
    public void delete(FireTruckEntity entity) {
        mFireTruckEntities.remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        List<Integer> integerList =
                StreamSupport.stream(integers.spliterator(),false).collect(Collectors.toList());

        mFireTruckEntities.removeIf(i -> integerList.contains(i.fireTruckId));
    }

    @Override
    public void deleteAll(Iterable<? extends FireTruckEntity> entities) {
        for (FireTruckEntity fte : entities)
            mFireTruckEntities.remove(fte);
    }

    @Override
    public void deleteAll() {
        mFireTruckEntities.clear();
    }

    @Override
    public List<FireTruckEntity> findAllByFilter(String name, Double priceStart, Double priceEnd, String vin,
                                                 Integer productionYearStart, Integer productionYearEnd,
                                                 String operationalNumbers, String type, Integer horsepowerStart,
                                                 Integer horsepowerEnd, Integer numberOfSeatsStart,
                                                 Integer numberOfSeatsEnd, Integer mileageStart, Integer mileageEnd)
    {
        return mFireTruckEntities.stream()
                .filter(i -> i.name.equals(name))
                .filter(i -> i.price >= priceStart && i.price <= priceEnd)
                .filter(i -> i.vin.equals(vin))
                .filter(i -> i.productionYear >= productionYearStart && i.productionYear <= productionYearEnd)
                .filter(i -> i.operationalNumbers.equals(operationalNumbers))
                .filter(i -> i.type.equals(type))
                .filter(i -> i.horsepower >= horsepowerStart && i.horsepower <= horsepowerEnd)
                .filter(i -> i.numberOfSeats >= numberOfSeatsStart && i.numberOfSeats <= numberOfSeatsEnd)
                .filter(i -> i.mileage >= mileageStart && i.mileage <= mileageEnd)
                .collect(Collectors.toList());
    }
}
