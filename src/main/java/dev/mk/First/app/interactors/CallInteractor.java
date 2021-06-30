package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.CallConverter;
import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.entities.EquipmentEntity;
import dev.mk.First.app.data.repositories.CallRepository;
import dev.mk.First.web.models.CallModel;
import dev.mk.First.web.models.EquipmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CallInteractor {

    @Autowired
    private CallRepository mCallRepository;

    @Autowired
    private CallConverter mCallsConverter;

    public Collection<CallEntity> findAll() {
        return mCallRepository.findAll();
    }

    public void saveEntity(CallModel callModel) {
        mCallRepository.save(mCallsConverter.convertToEntity(callModel));
    }

    public void deleteEntity(Integer id) {
        mCallRepository.deleteById(id);
    }

    public void deleteEntities(Collection<Integer> id) {
        mCallRepository.deleteAllById(id);
    }

    public void updateEntity(Integer id, CallModel updatedCall) {

        mCallRepository.deleteById(id);
        CallEntity updatedEntity = mCallsConverter.convertToEntity(updatedCall);
        updatedEntity.id = id;
        mCallRepository.save(updatedEntity);

    }

}
