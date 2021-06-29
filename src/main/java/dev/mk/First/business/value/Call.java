package dev.mk.First.business.value;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

public class Call {

    private LocalDateTime mStartDateTime;
    private LocalDateTime mEndDateTime;
    private CallType mCallType;
    private String mLocation;
    private String mDetails;
    private Collection<FireTruck> mFireTrucksInAction;
    private Collection<StaffMember> mStaffMembersInAction;

    public LocalDateTime getStartDateTime() {
        return mStartDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return mEndDateTime;
    }

    public CallType getCallType() {
        return mCallType;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDetails() {
        return mDetails;
    }

    public Collection<FireTruck> getFireTrucksInAction() {
        return mFireTrucksInAction;
    }

    public Collection<StaffMember> getStaffMembersInAction() {
        return mStaffMembersInAction;
    }

    public Call(
            LocalDateTime startDateTime, LocalDateTime endDateTime, CallType callType, String location,
            String description, Collection<FireTruck> fireTrucksInAction, Collection<StaffMember> staffMembersInAction)
    {
        mStartDateTime = startDateTime;
        mEndDateTime = endDateTime;
        mCallType = callType;
        mLocation = location;
        mDetails = description;
        mFireTrucksInAction = fireTrucksInAction;
        mStaffMembersInAction = staffMembersInAction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return getStartDateTime().equals(call.getStartDateTime())
                && getEndDateTime().equals(call.getEndDateTime())
                && getCallType() == call.getCallType()
                && getLocation().equals(call.getLocation())
                && Objects.equals(getDetails(), call.getDetails())
                && getFireTrucksInAction().equals(call.getFireTrucksInAction())
                && getStaffMembersInAction().equals(call.getStaffMembersInAction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getStartDateTime(), getEndDateTime(), getCallType(), getLocation(), getDetails(),
                getFireTrucksInAction(), getStaffMembersInAction()
        );
    }
}
