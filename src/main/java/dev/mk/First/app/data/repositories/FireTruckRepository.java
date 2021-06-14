package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.FireTruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireTruckRepository extends JpaRepository<FireTruckEntity, Integer> {


}