package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.StaffMemberConverter;
import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.repositories.StaffMemberRepository;
import dev.mk.First.business.value.BloodType;
import dev.mk.First.business.value.CallType;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.StaffMemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class StaffMemberInteractor {

    @Autowired
    private StaffMemberRepository mStaffMemberRepository;

    @Autowired
    private StaffMemberConverter mStaffMemberConverter;

    public Collection<StaffMemberModel> findAll() {
        return mStaffMemberConverter
                .convertCollectionToModel((Collection < StaffMemberEntity >) mStaffMemberRepository.findAll());
    }

    public void saveEntity(StaffMemberModel staffMemberModel) {
        mStaffMemberRepository.save(mStaffMemberConverter.convertToEntity(staffMemberModel));
    }

    public void deleteEntity(Integer id) {
        mStaffMemberRepository.deleteById(id);
    }

    public void deleteEntities(Collection<Integer> id) {
        mStaffMemberRepository.deleteAllById(id);
    }

    public void updateEntity(Integer id, StaffMemberModel updatedStaffMember) {

        mStaffMemberRepository.deleteById(id);
        StaffMemberEntity updatedEntity = mStaffMemberConverter.convertToEntity(updatedStaffMember);
        updatedEntity.staffMemberId = id;
        mStaffMemberRepository.save(updatedEntity);

    }

    public Collection<StaffMemberModel> findFiltered(
            @Nullable String firstname,
            @Nullable String lastname,
            @Nullable LocalDate joiningTimeStart,
            @Nullable LocalDate joiningTimeEnd,
            @Nullable String pesel,
            @Nullable String address,
            @Nullable String city,
            @Nullable LocalDate periodicExaminationsExpiryDateStart,
            @Nullable LocalDate periodicExaminationsExpiryDateEnd,
            @Nullable Boolean isDriver,
            @Nullable LocalDate birthdateStart,
            @Nullable LocalDate birthdateEnd,
            @Nullable BloodType bloodType,
            @Nullable String email,
            @Nullable String phoneNumber
    ) {
        return mStaffMemberConverter.convertCollectionToModel(mStaffMemberRepository.findAllByFilter(
                firstname, lastname, joiningTimeStart, joiningTimeEnd, pesel, address, city,
                periodicExaminationsExpiryDateStart, periodicExaminationsExpiryDateEnd, isDriver,
                birthdateStart, birthdateEnd, bloodType, email, phoneNumber
        ));
    }
    
}
