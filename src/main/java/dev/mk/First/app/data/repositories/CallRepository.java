package dev.mk.First.app.data.repositories;

import dev.mk.First.app.data.entities.CallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends CrudRepository<CallEntity, Integer> {
}
