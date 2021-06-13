package dev.mk.First.app.data.entity;

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
    public TrainingType trainingType;

    @OneToOne
    @Column(name = "staff_member_id")
    public StaffMemberEntity staffMemberEntity;

    public TrainingEntity() {
    }

    public TrainingEntity(LocalDate trainingDate, LocalDate expirationDate, TrainingType trainingType,
                          StaffMemberEntity staffMemberEntity) {
        this.trainingDate = trainingDate;
        this.expirationDate = expirationDate;
        this.trainingType = trainingType;
        this.staffMemberEntity = staffMemberEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingEntity that = (TrainingEntity) o;
        return trainingId == that.trainingId
                && Objects.equals(trainingDate, that.trainingDate)
                && Objects.equals(expirationDate, that.expirationDate)
                && trainingType == that.trainingType
                && Objects.equals(staffMemberEntity, that.staffMemberEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingId, trainingDate, expirationDate, trainingType, staffMemberEntity);
    }
}
