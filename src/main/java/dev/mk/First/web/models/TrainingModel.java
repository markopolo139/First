package dev.mk.First.web.models;

import dev.mk.First.web.validation.ValidTrainingType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
}
