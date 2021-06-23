package dev.mk.First.app.interactors;

import dev.mk.First.app.data.repositories.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffMemberInteractor {

    @Autowired
    private StaffMemberRepository mStaffMemberRepository;
}
