package dev.mk.First.app.converters;


import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.business.value.CallType;
import dev.mk.First.web.models.CallModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

public class CallConverterImpl implements CallConverter{

    @Autowired
    private StaffMemberConverter mStaffMemberConverter;

    @Autowired
    private FireTruckConverter mFireTruckConverter;

    @Override
    public CallEntity convertToEntity(CallModel callModel) {
        return new CallEntity(
                callModel.startDateTime,
                callModel.endDateTime,
                callModel.location,
                callModel.details,
                CallType.valueOf(callModel.callType),
                mFireTruckConverter.convertListToEntity(callModel.fireTrucksInAction),
                mStaffMemberConverter.convertCollectionToEntity(callModel.staffMembersInAction)
        );
    }

    @Override
    public CallModel convertToModel(CallEntity callEntity) {
        return new CallModel(
                callEntity.startDate,
                callEntity.endDate,
                callEntity.callType.name(),
                callEntity.location,
                callEntity.details,
                mFireTruckConverter.convertListToModel(callEntity.fireTrucksInAction),
                mStaffMemberConverter.convertCollectionToModel(callEntity.staffMembersInAction)
        );
    }

    @Override
    public Collection<CallEntity> convertListToEntity(Collection<CallModel> callModelList) {
        return callModelList.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<CallModel> convertListToModel(Collection<CallEntity> callEntityList) {
        return callEntityList.stream().map(this::convertToModel).collect(Collectors.toList());
    }
}
