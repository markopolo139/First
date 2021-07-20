package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.StaffMemberConverter;
import dev.mk.First.app.data.entities.StaffMemberEntity;
import dev.mk.First.app.data.repositories.StaffMemberRepository;
import dev.mk.First.web.models.StaffMemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StaffMemberInteractor {

    @Autowired
    private StaffMemberRepository mStaffMemberRepository;

    @Autowired
    private StaffMemberConverter mStaffMemberConverter;

    public Collection<StaffMemberEntity> findAll() {
        return (Collection<StaffMemberEntity>) mStaffMemberRepository.findAll();
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
        updatedEntity.id = id;
        mStaffMemberRepository.save(updatedEntity);

    }
    
}
