package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.business.value.CallType;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CallRepository extends CrudRepository<CallEntity, Integer> {

    @Query(
            "select ce from CallEntity ce " +
            "where (:startDateStart is null or ce.startDate >= :startDateStart) " +
                    "and (:startDateEnd is null or ce.startDate <= :startDateEnd) " +
                    "and (:endDateStart is null or ce.endDate >= :endDateStart) " +
                    "and (:endDateEnd is null or ce.endDate <= :endDateEnd) " +
                    "and (:location is null or ce.location = :location) " +
                    "and (:details is null or ce.details = :details) " +
                    "and (:callType is null or ce.callType = :callType) "
    )
    List<CallEntity> findAllByFilter(@Param("startDateStart") LocalDateTime startDateStart,
                                     @Param("startDateEnd") LocalDateTime startDateEnd,
                                     @Param("endDateStart") LocalDateTime endDateStart,
                                     @Param("endDateEnd") LocalDateTime endDateEnd,
                                     @Param("location") String location,
                                     @Param("details") String details,
                                     @Param("callType") CallType callType);
}
