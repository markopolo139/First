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
                    "and (:production_yearStart is null or fte.productionYear >= :production_yearStart)" +
                    "and (:production_yearEnd is null or fte.productionYear <= :production_yearEnd)" +
                    "and (:operational_numbers is null or fte.operationalNumbers = :operational_numbers)" +
                    "and (:type is null or fte.type = :type)" +
                    "and (:horsepowerStart is null or fte.horsepower >= :horsepowerStart)" +
                    "and (:horsepowerEnd is null or fte.horsepower <= :horsepowerEnd)" +
                    "and (:number_of_seatsStart is null or fte.numberOfSeats >= :number_of_seatsStart)" +
                    "and (:number_of_seatsEnd is null or fte.numberOfSeats <= :number_of_seatsEnd)" +
                    "and (:mileageStart is null or fte.mileage >= :mileageStart)" +
                    "and (:mileageEnd is null or fte.mileage <= :mileageEnd)"
    )
    List<FireTruckEntity> findAllByFilter(@Param("name") String name,
                                          @Param("priceStart") Double priceStart,
                                          @Param("priceEnd") Double priceEnd,
                                          @Param("vin") String vin,
                                          @Param("production_yearStart") Integer production_yearStart,
                                          @Param("production_yearEnd") Integer production_yearEnd,
                                          @Param("operational_numbers") String operational_numbers,
                                          @Param("type") String type,
                                          @Param("horsepowerStart") Integer horsepowerStart,
                                          @Param("horsepowerEnd") Integer horsepowerEnd,
                                          @Param("number_of_seatsStart") Integer number_of_seatsStart,
                                          @Param("number_of_seatsEnd") Integer number_of_seatsEnd,
                                          @Param("mileageStart") Integer mileageStart,
                                          @Param("mileageEnd") Integer mileageEnd);
}
