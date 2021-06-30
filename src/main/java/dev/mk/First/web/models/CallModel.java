package dev.mk.First.web.models;

import dev.mk.First.web.validation.ValidCallType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

public class CallModel {

    @NotNull
    public LocalDateTime startDateTime;

    @NotNull
    public LocalDateTime endDateTime;

    @NotBlank
    @ValidCallType
    public String callType;

    @NotBlank
    public String location;

    @NotBlank
    public String details;

    @NotEmpty
    public Collection<FireTruckModel> fireTrucksInAction;

    @NotEmpty
    public Collection<StaffMemberModel> staffMembersInAction;

    public CallModel() {
    }

    public CallModel(LocalDateTime startDateTime, LocalDateTime endDateTime, String callType, String location,
                     String details, Collection<FireTruckModel> fireTrucksInAction,
                     Collection<StaffMemberModel> staffMembersInAction) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.callType = callType;
        this.location = location;
        this.details = details;
        this.fireTrucksInAction = fireTrucksInAction;
        this.staffMembersInAction = staffMembersInAction;
    }

    public CallModel(LocalDateTime startDateTime, LocalDateTime endDateTime,
                     String callType, String location, String details) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.callType = callType;
        this.location = location;
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallModel callModel = (CallModel) o;
        return Objects.equals(startDateTime, callModel.startDateTime)
                && Objects.equals(endDateTime, callModel.endDateTime)
                && Objects.equals(callType, callModel.callType)
                && Objects.equals(location, callModel.location)
                && Objects.equals(details, callModel.details)
                && Objects.equals(fireTrucksInAction, callModel.fireTrucksInAction)
                && Objects.equals(staffMembersInAction, callModel.staffMembersInAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDateTime, endDateTime, callType, location, details, fireTrucksInAction,
                staffMembersInAction);
    }
}
