package org.employment;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;

    public PartTimeEmployee(String name, String department, double hourlyRate) {
        super(name, department);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}