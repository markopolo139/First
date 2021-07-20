package dev.mk.First.web.controllers;

import dev.mk.First.app.data.entities.CallEntity;
import dev.mk.First.app.data.repositories.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
public class TestController {

    @Autowired
    private CallRepository mCallRepository;

    @GetMapping(path = "/api/v1/test")
    public List<CallEntity> test(
            @RequestParam(value = "startDateStart", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateStart,
            @RequestParam(name = "startDateEnd", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateEnd
    ) {
        return null;
    }
}
