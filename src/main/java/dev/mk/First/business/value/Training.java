package dev.mk.First.business.value;

import java.time.LocalDate;
import java.util.Objects;

public class Training {

    private LocalDate mTrainingDate;
    private LocalDate mExpirationDate;
    private TrainingType mType;

    public LocalDate getTrainingDate() {
        return mTrainingDate;
    }

    public LocalDate getExpirationDate() {
        return mExpirationDate;
    }

    public TrainingType getType() {
        return mType;
    }

    public Training(LocalDate trainingDate, LocalDate expirationDate, TrainingType type) {
        mTrainingDate = trainingDate;
        mExpirationDate = expirationDate;
        mType = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(getTrainingDate(), training.getTrainingDate()) && Objects.equals(getExpirationDate(), training.getExpirationDate()) && Objects.equals(getType(), training.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrainingDate(), getExpirationDate(), getType());
    }
}
