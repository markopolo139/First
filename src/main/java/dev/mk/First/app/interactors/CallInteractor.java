package dev.mk.First.app.interactors;

import dev.mk.First.app.converters.CallConverter;
import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.repositories.CallRepository;
import dev.mk.First.business.value.CallType;
import dev.mk.First.web.models.CallModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class CallInteractor {

    @Autowired
    private CallRepository mCallRepository;

    @Autowired
    private CallConverter mCallsConverter;

    public Collection<CallModel> findAll() {
        return mCallsConverter.convertCollectionToModel((Collection < CallEntity >) mCallRepository.findAll());
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
        updatedEntity.callId = id;
        mCallRepository.save(updatedEntity);

    }

    public Collection<CallModel> findFiltered(
            @Nullable LocalDateTime startDateStart,
            @Nullable LocalDateTime startDateEnd,
            @Nullable LocalDateTime endDateStart,
            @Nullable LocalDateTime endDateEnd,
            @Nullable String location,
            @Nullable String details,
            @Nullable CallType callType
    ) {
        return mCallsConverter.convertCollectionToModel(mCallRepository.findAllByFilter(
                startDateStart, startDateEnd, endDateStart, endDateEnd, location, details, callType
        ));
    }

}
