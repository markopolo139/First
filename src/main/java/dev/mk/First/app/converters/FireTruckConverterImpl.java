package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.FireTruckEntity;
import dev.mk.First.web.models.FireTruckModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

public class FireTruckConverterImpl implements FireTruckConverter {

    @Autowired
    private FireTruckParameterConverter mFireTruckParameterConverter;

    @Override
    public FireTruckModel convertToModel(FireTruckEntity fireTruckEntity) {
        return new FireTruckModel(fireTruckEntity.name, fireTruckEntity.price, fireTruckEntity.vin,
                fireTruckEntity.productionYear, fireTruckEntity.operationalNumbers, fireTruckEntity.type,
                fireTruckEntity.horsepower, fireTruckEntity.numberOfSeats, fireTruckEntity.mileage,
                mFireTruckParameterConverter.convertCollectionToModel(fireTruckEntity.parameters));
    }

    @Override
    public FireTruckEntity convertToEntity(FireTruckModel fireTruckModel) {
        return new FireTruckEntity(fireTruckModel.name, fireTruckModel.price, fireTruckModel.vin,
                fireTruckModel.productionYear, fireTruckModel.operationalNumber, fireTruckModel.type,
                fireTruckModel.horsepower, fireTruckModel.numberOfSeats, fireTruckModel.mileage,
                mFireTruckParameterConverter.convertCollectionToEntity(fireTruckModel.fireTruckParameters));
    }

    @Override
    public Collection<FireTruckModel> convertCollectionToModel(Collection<FireTruckEntity> fireTruckEntities) {
        return fireTruckEntities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    @Override
    public Collection<FireTruckEntity> convertCollectionToEntity(Collection<FireTruckModel> fireTruckModels) {
        return fireTruckModels.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
