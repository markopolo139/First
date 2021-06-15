package dev.mk.First.app.data.entities;

import dev.mk.First.business.value.TrainingType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "trainings")
public class TrainingEntity {

    @Id
    @GeneratedValue
    @Column(name = "training_id")
    public int trainingId;

    @Column(name = "training_date")
    public LocalDate trainingDate;

    @Column(name = "expiration_date")
    public LocalDate expirationDate;

    @Column(name = "training_type")
    @Enumerated(EnumType.STRING)
    public TrainingType trainingType;

    public TrainingEntity() {
    }

    public TrainingEntity(LocalDate trainingDate, LocalDate expirationDate, TrainingType trainingType) {
        this.trainingDate = trainingDate;
        this.expirationDate = expirationDate;
        this.trainingType = trainingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingEntity that = (TrainingEntity) o;
        return trainingId == that.trainingId
                && trainingDate.equals(that.trainingDate)
                && Objects.equals(expirationDate, that.expirationDate)
                && trainingType == that.trainingType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingId, trainingDate, expirationDate, trainingType);
    }
}
