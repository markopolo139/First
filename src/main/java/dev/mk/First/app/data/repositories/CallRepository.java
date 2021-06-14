package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.CallsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository<CallsEntity, Integer> {
}
