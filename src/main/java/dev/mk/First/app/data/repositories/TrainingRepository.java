package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.TrainingEntity;
import dev.mk.First.business.value.TrainingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<TrainingEntity, Integer> {

    @Query(
            "select te from TrainingEntity te " +
                    "where (:trainingDateStart is null or te.trainingDate >= :trainingDateStart)" +
                    "and (:trainingDateEnd is null or te.trainingDate <= :trainingDateEnd)" +
                    "and (:expirationDateStart is null or te.expirationDate >= :expirationDateStart)" +
                    "and (:expirationDateEnd is null or te.expirationDate <= :expirationDateEnd)" +
                    "and (:trainingType is null or te.trainingType = :trainingType)"
    )
    List<TrainingEntity> findAllByFilter(@Param("trainingDateStart") LocalDate trainingDateStart,
                                         @Param("trainingDateEnd") LocalDate trainingDateEnd,
                                         @Param("expirationDateStart") LocalDate expirationDateStart,
                                         @Param("expirationDateEnd") LocalDate expirationDateEnd,
                                         @Param("trainingType") TrainingType trainingType);
}
