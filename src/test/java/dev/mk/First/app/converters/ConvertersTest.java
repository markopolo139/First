package dev.mk.First.app.converters;

import dev.mk.First.app.data.entities.*;
import dev.mk.First.business.value.BloodType;
import dev.mk.First.business.value.CallType;
import dev.mk.First.business.value.FireTruck;
import dev.mk.First.business.value.TrainingType;
import dev.mk.First.web.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

@SpringBootTest(classes = {
        CallConverter.class,
        CallConverterImpl.class,
        FireTruckConverter.class,
        FireTruckConverterImpl.class,
        FireTruckParameterConverter.class,
        FireTruckParameterConverterImpl.class,
        StaffMemberConverter.class,
        StaffMemberConverterImpl.class,
        TrainingConverter.class,
        TrainingConverterImpl.class
})
public class ConvertersTest {

    @Autowired
    private CallConverter mCallConverter;

    @Autowired
    private FireTruckConverter mFireTruckConverter;

    @Autowired
    private StaffMemberConverter mStaffMemberConverter;

    @Test
    void testConverter() {

        StaffMemberModel testStaffMemberModel = new StaffMemberModel(
                "Marek",
                "Seget",
                LocalDate.MIN,
                "02310201238",
                "Gorska",
                "Poznan",
                LocalDate.MAX,
                false,
                LocalDate.MIN,
                "AB+",
                "marekseget@onet.pl",
                "506498725",
                Arrays.asList(
                        new TrainingModel(
                                LocalDate.MIN,
                                LocalDate.MAX,
                                TrainingType.LIFT.name()
                        )
                )
        );

        FireTruckModel testFireTruckModel = new FireTruckModel(
                "Test1",
                100.00,
                "aqwqrgfzga",
                1992,
                "SAPOQ124",
                "Test",
                120,
                5,
                80,
                Arrays.asList(
                        new FireTruckParameterModel(
                                "Key",
                                "value"
                        )
                )
        );

        CallModel testCallModel = new CallModel(
                LocalDateTime.MIN,
                LocalDateTime.MAX,
                CallType.FALSE_ALARM.name(),
                "Poznan",
                "abc",
                Arrays.asList(
                        testFireTruckModel
                ),
                Arrays.asList(
                        testStaffMemberModel
                )
        );

        FireTruckEntity testFireTruckEntity = new FireTruckEntity(
                "Test1",
                100.00,
                "aqwqrgfzga",
                1992,
                "SAPOQ124",
                "Test",
                120,
                5,
                80,
                Arrays.asList(
                        new FireTruckParameterEntity(
                                "Key",
                                "value"
                        )
                )
        );

        StaffMemberEntity testStaffMemberEntity = new StaffMemberEntity(
                "Marek",
                "Seget",
                LocalDate.MIN,
                "02310201238",
                "Gorska",
                "Poznan",
                LocalDate.MAX,
                false,
                LocalDate.MIN,
                BloodType.AB_PLUS,
                "marekseget@onet.pl",
                "506498725",
                Arrays.asList(
                        new TrainingEntity(
                                LocalDate.MIN,
                                LocalDate.MAX,
                                TrainingType.LIFT
                        )
                )

        );

        CallEntity testCallEntity = new CallEntity(
                LocalDateTime.MIN,
                LocalDateTime.MAX,
                "Poznan",
                "abc",
                CallType.FALSE_ALARM,
                Arrays.asList(
                        testFireTruckEntity
                ),
                Arrays.asList(
                        testStaffMemberEntity
                )
        );



        Assertions.assertEquals(testCallEntity, mCallConverter.convertToEntity(testCallModel));

        Assertions.assertEquals(testStaffMemberModel, mStaffMemberConverter.convertToModel(testStaffMemberEntity));

        Assertions.assertEquals(testFireTruckModel, mFireTruckConverter.convertToModel(testFireTruckEntity));

        Assertions.assertEquals(testCallModel, mCallConverter.convertToModel(testCallEntity));
    }

}
