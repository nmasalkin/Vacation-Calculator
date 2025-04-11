package ru.vsu.cs.masalkin.vacationcalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.vsu.cs.masalkin.vacationcalculator.data.CalendarData;
import ru.vsu.cs.masalkin.vacationcalculator.dto.CalculateDTO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class CalculateService {

    public double calculate(CalculateDTO calculateDTO) {
        double vacationPayments = 0;
        if (calculateDTO.getAverageSalary() > 0 && calculateDTO.getVacationDays() > 0) {
            vacationPayments = (calculateDTO.getAverageSalary() / 29.3) * getDays(calculateDTO.getStartVacationDate(), calculateDTO.getVacationDays());
        }
        return (double) Math.round(vacationPayments * 100) / 100;
    }

    private int getDays(Date date, int vacationDays) {
        for (int i = 0; i < vacationDays; i++) {
            if (isHoliday(date)) {
                vacationDays++;
            }
            date.setDate(date.getDate() + 1);
        }
        return vacationDays;
    }

    private boolean isHoliday(Date date) {
        ObjectMapper mapper = new ObjectMapper();
        CalendarData calendarData;
        try {
            calendarData = mapper.readValue(new File("src/main/resources/static/files/calendar.json"), CalendarData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < calendarData.months.size(); i++) {
            if (calendarData.months.get(i).getMonth() == date.getMonth() + 1) {
                for (String day : calendarData.months.get(i).days.split(",")) {
                    if (Integer.parseInt(day) == date.getDate()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
