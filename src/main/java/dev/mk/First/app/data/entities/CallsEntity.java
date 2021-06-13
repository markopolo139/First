package dev.mk.First.app.data.entities;

import dev.mk.First.business.value.CallType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "calls")
public class CallsEntity {

    @Id
    @GeneratedValue
    @Column(name = "call_id")
    public int id;

    @Column(name = "startDate")
    public LocalDateTime startDate;

    @Column(name = "endDate")
    public LocalDateTime endDate;

    @Column(name = "location")
    public String location;

    @Column(name = "details")
    public String details;

    @OneToOne
    @Column(name = "type")
    public CallType callType;

    public CallsEntity(
            LocalDateTime startDate, LocalDateTime endDate, String location, String details, CallType callType
    )
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.details = details;
        this.callType = callType;
    }

    public CallsEntity() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallsEntity that = (CallsEntity) o;
        return id == that.id
                && startDate.equals(that.startDate)
                && endDate.equals(that.endDate)
                && location.equals(that.location)
                && Objects.equals(details, that.details)
                && callType == that.callType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, location, details, callType);
    }
}
