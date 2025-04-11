package ru.vsu.cs.masalkin.vacationcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.masalkin.vacationcalculator.dto.CalculateDTO;
import ru.vsu.cs.masalkin.vacationcalculator.service.CalculateService;

@RestController
public class CalculateController {

    private CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping("/calculate")
    public double calculate(@RequestBody CalculateDTO calculateDTO) {
        return calculateService.calculate(calculateDTO);
    }
}
