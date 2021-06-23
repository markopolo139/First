package dev.mk.First.app.interactors;

import dev.mk.First.app.data.repositories.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallInteractor {

    @Autowired
    private CallRepository mCallRepository;
}
