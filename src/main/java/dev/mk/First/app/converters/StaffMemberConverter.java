package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.business.value.StaffMember;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.StaffMemberModel;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface StaffMemberConverter {

    StaffMemberEntity convertToEntity(StaffMemberModel staffMemberModel);

    StaffMemberModel convertToModel(StaffMemberEntity staffMemberEntity);

    Collection<StaffMemberEntity> convertListToEntity(Collection<StaffMemberModel> staffMemberModels);

    Collection<StaffMemberModel> convertListToModel(Collection<StaffMemberEntity> staffMemberEntities);

}
