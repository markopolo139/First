package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.business.value.BloodType;
import dev.mk.First.web.models.StaffMemberModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

public class StaffMemberConverterImpl implements StaffMemberConverter {

    @Autowired
    private TrainingConverter mTrainingConverter;

    @Override
    public StaffMemberEntity convertToEntity(StaffMemberModel staffMemberModel) {
        return new StaffMemberEntity(
                staffMemberModel.firstname,
                staffMemberModel.lastname,
                staffMemberModel.joiningDate,
                staffMemberModel.pesel,
                staffMemberModel.address,
                staffMemberModel.city,
                staffMemberModel.periodicExaminationsExpiryDate,
                staffMemberModel.isDriver,
                staffMemberModel.birthdate,
                BloodType.fromString(staffMemberModel.bloodType),
                staffMemberModel.email,
                staffMemberModel.phoneNumber,
                mTrainingConverter.covertCollectionToEntity(staffMemberModel.trainings)
        );
    }

    @Override
    public StaffMemberModel convertToModel(StaffMemberEntity staffMemberEntity) {
        return new StaffMemberModel(
                staffMemberEntity.firstname,
                staffMemberEntity.lastname,
                staffMemberEntity.joiningDate,
                staffMemberEntity.pesel,
                staffMemberEntity.address,
                staffMemberEntity.city,
                staffMemberEntity.periodicExaminationsExpiryDate,
                staffMemberEntity.isDriver,
                staffMemberEntity.birthdate,
                staffMemberEntity.bloodType.getBloodType(),
                staffMemberEntity.email,
                staffMemberEntity.phoneNumber,
                mTrainingConverter.covertCollectionToModel(staffMemberEntity.trainings)
        );
    }

    @Override
    public Collection<StaffMemberEntity> convertCollectionToEntity(Collection<StaffMemberModel> staffMemberModels) {
        return staffMemberModels.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

    @Override
    public Collection<StaffMemberModel> convertCollectionToModel(Collection<StaffMemberEntity> staffMemberEntities) {
        return staffMemberEntities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

}
