package dev.mk.First.app.data.entities;

import dev.mk.First.business.value.CallType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "calls")
public class CallEntity {

    @Id
    @GeneratedValue
    @Column(name = "call_id")
    public int callId;

    @Column(name = "startDate")
    public LocalDateTime startDate;

    @Column(name = "endDate")
    public LocalDateTime endDate;

    @Column(name = "location")
    public String location;

    @Column(name = "details")
    public String details;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public CallType callType;

    @ManyToMany
    @JoinTable(name = "fire_trucks_in_action",
            joinColumns = {@JoinColumn(name = "call_id")},
            inverseJoinColumns = {@JoinColumn(name = "fire_truck_id")})
    public Collection<FireTruckEntity> fireTrucksInAction;

    @ManyToMany
    @JoinTable(name = "staff_members_in_action",
            joinColumns = {@JoinColumn(name = "call_id")},
            inverseJoinColumns = {@JoinColumn(name = "staff_member_id")})
    public Collection<StaffMemberEntity> staffMembersInAction;

    public CallEntity(
            LocalDateTime startDate, LocalDateTime endDate, String location, String details, CallType callType
    )
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.details = details;
        this.callType = callType;
    }

    public CallEntity(
            LocalDateTime startDate, LocalDateTime endDate, String location, String details, CallType callType,
            Collection<FireTruckEntity> fireTrucksInAction, Collection<StaffMemberEntity> staffMembersInAction)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.details = details;
        this.callType = callType;
        this.fireTrucksInAction = fireTrucksInAction;
        this.staffMembersInAction = staffMembersInAction;
    }

    public CallEntity() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallEntity that = (CallEntity) o;
        return callId == that.callId
                && startDate.equals(that.startDate)
                && endDate.equals(that.endDate)
                && location.equals(that.location)
                && Objects.equals(details, that.details)
                && callType == that.callType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(callId, startDate, endDate, location, details, callType);
    }
}
