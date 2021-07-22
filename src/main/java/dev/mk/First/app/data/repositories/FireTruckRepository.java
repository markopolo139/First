package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.FireTruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireTruckRepository extends CrudRepository<FireTruckEntity, Integer> {

    @Query(
            "select fte from FireTruckEntity fte " +
                    "where (:name is null or fte.name = :name)" +
                    "and (:priceStart is null or fte.price >= :priceStart)" +
                    "and (:priceEnd is null or fte.price <= :priceEnd)" +
                    "and (:vin is null or fte.vin = :vin)" +
                    "and (:productionYearStart is null or fte.productionYear >= :productionYearStart)" +
                    "and (:productionYearEnd is null or fte.productionYear <= :productionYearEnd)" +
                    "and (:operationalNumbers is null or fte.operationalNumbers = :operationalNumbers)" +
                    "and (:type is null or fte.type = :type)" +
                    "and (:horsepowerStart is null or fte.horsepower >= :horsepowerStart)" +
                    "and (:horsepowerEnd is null or fte.horsepower <= :horsepowerEnd)" +
                    "and (:numberOfSeatsStart is null or fte.numberOfSeats >= :numberOfSeatsStart)" +
                    "and (:numberOfSeatsEnd is null or fte.numberOfSeats <= :numberOfSeatsEnd)" +
                    "and (:mileageStart is null or fte.mileage >= :mileageStart)" +
                    "and (:mileageEnd is null or fte.mileage <= :mileageEnd)"
    )
    List<FireTruckEntity> findAllByFilter(@Param("name") String name,
                                          @Param("priceStart") Double priceStart,
                                          @Param("priceEnd") Double priceEnd,
                                          @Param("vin") String vin,
                                          @Param("productionYearStart") Integer productionYearStart,
                                          @Param("productionYearEnd") Integer productionYearEnd,
                                          @Param("operationalNumbers") String operationalNumbers,
                                          @Param("type") String type,
                                          @Param("horsepowerStart") Integer horsepowerStart,
                                          @Param("horsepowerEnd") Integer horsepowerEnd,
                                          @Param("numberOfSeatsStart") Integer numberOfSeatsStart,
                                          @Param("numberOfSeatsEnd") Integer numberOfSeatsEnd,
                                          @Param("mileageStart") Integer mileageStart,
                                          @Param("mileageEnd") Integer mileageEnd);
}
