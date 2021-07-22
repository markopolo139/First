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
            "select te from TrainingEntity te" +
                    "where (:training_dateStart is null or te.trainingDate >= :training_dateStart)" +
                    "and (:training_dateEnd is null or te.trainingDate <= :training_dateEnd)" +
                    "and (:expiration_dateStart is null or te.expirationDate >= :expiration_dateStart)" +
                    "and (:expiration_dateEnd is null or te.expirationDate <= :expiration_dateEnd)" +
                    "and (:training_type is null or te.trainingType = :training_type)"
    )
    List<TrainingEntity> findAllByFilter(@Param("training_dateStart") LocalDate training_dateStart,
                                         @Param("training_dateEnd") LocalDate training_dateEnd,
                                         @Param("expiration_dateStart") LocalDate expiration_dateStart,
                                         @Param("expiration_dateEnd") LocalDate expiration_dateEnd,
                                         @Param("training_type") TrainingType training_type);
}
