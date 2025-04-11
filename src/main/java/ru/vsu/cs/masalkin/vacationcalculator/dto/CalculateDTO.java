package ru.vsu.cs.masalkin.vacationcalculator.dto;

import java.util.Date;

public class CalculateDTO {
    private double averageSalary;
    private Date startVacationDate;
    private int vacationDays;

    public CalculateDTO(double averageSalary, Date startVacationDate, int vacationDays) {
        this.averageSalary = averageSalary;
        this.startVacationDate = startVacationDate;
        this.vacationDays = vacationDays;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public Date getStartVacationDate() {
        return startVacationDate;
    }

    public int getVacationDays() {
        return vacationDays;
    }
}
