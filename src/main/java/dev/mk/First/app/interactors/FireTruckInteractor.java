package dev.mk.First.app.interactors;

import dev.mk.First.app.data.repositories.FireTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FireTruckInteractor {

    @Autowired
    private FireTruckRepository mFireTruckRepository;
}
