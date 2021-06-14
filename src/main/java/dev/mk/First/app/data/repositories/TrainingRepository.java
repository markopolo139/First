package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
}
