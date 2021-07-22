package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<EquipmentEntity, Integer> {

    @Query(
            "select ee from EquipmentEntity ee " +
                    "where (:name is null or ee.name = :name) " +
                    "and (:priceStart is null or ee.price >= :priceStart)" +
                    "and (:priceEnd is null or ee.price <= :priceEnd)" +
                    "and (:serialNumber is null or ee.serialNumber = :serialNumber)"
    )
    List<EquipmentEntity> findAllByFilter(@Param("name") String name,
                                          @Param("priceStart") Double priceStart,
                                          @Param("priceEnd") Double priceEnd,
                                          @Param("serialNumber") String serialNumber);
}
