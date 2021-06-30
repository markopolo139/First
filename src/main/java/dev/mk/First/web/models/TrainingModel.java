package dev.mk.First.web.models;

import dev.mk.First.web.validation.ValidTrainingType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class TrainingModel {

    @NotNull
    public LocalDate trainingDate;

    public LocalDate expirationDate;

    @NotBlank
    @ValidTrainingType
    public String trainingType;

    public TrainingModel() {
    }

    public TrainingModel(LocalDate trainingDate, LocalDate expirationDate, String trainingType) {
        this.trainingDate = trainingDate;
        this.expirationDate = expirationDate;
        this.trainingType = trainingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingModel that = (TrainingModel) o;
        return Objects.equals(
                trainingDate, that.trainingDate)
                && Objects.equals(expirationDate, that.expirationDate)
                && Objects.equals(trainingType, that.trainingType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingDate, expirationDate, trainingType);
    }
}
