package ru.vsu.cs.masalkin.vacationcalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vsu.cs.masalkin.vacationcalculator.controller.CalculateController;
import ru.vsu.cs.masalkin.vacationcalculator.dto.CalculateDTO;
import ru.vsu.cs.masalkin.vacationcalculator.service.CalculateService;

import java.util.Date;

@SpringBootTest
class VacationCalculatorApplicationTests {

    @Test
    void test1() {
        double averageSalary = 100000;
        Date startVacationDate = new Date(2025, 7, 1);
        int vacationDays = 10;
        double expectedVacationPayments = 34129.69;

        CalculateDTO calculateDTO = new CalculateDTO(averageSalary, startVacationDate, vacationDays);

        double vacationPayments = new CalculateController(new CalculateService()).calculate(calculateDTO);
        assert expectedVacationPayments == vacationPayments;
    }

    @Test
    void test2() {
        double averageSalary = 50000;
        Date startVacationDate = new Date(2025, 5, 17);
        int vacationDays = 13;
        double expectedVacationPayments = 22184.3;

        CalculateDTO calculateDTO = new CalculateDTO(averageSalary, startVacationDate, vacationDays);

        double vacationPayments = new CalculateController(new CalculateService()).calculate(calculateDTO);
        assert expectedVacationPayments == vacationPayments;
    }
}
