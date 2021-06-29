package dev.mk.First.web.models;

import dev.mk.First.business.value.CallType;
import dev.mk.First.business.value.FireTruck;
import dev.mk.First.business.value.StaffMember;
import dev.mk.First.web.validation.ValidCallType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Collection;

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
    public String description;

    @NotEmpty
    public Collection<FireTruckModel> fireTrucksInAction;

    @NotEmpty
    public Collection<StaffMemberModel> staffMembersInAction;

    public CallModel() {
    }

    public CallModel(LocalDateTime startDateTime, LocalDateTime endDateTime, String callType, String location,
                     String description, Collection<FireTruckModel> fireTrucksInAction,
                     Collection<StaffMemberModel> staffMembersInAction) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.callType = callType;
        this.location = location;
        this.description = description;
        this.fireTrucksInAction = fireTrucksInAction;
        this.staffMembersInAction = staffMembersInAction;
    }
}