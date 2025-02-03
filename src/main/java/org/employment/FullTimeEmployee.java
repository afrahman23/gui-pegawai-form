package org.employment;

public class FullTimeEmployee extends Employee {
    private double salary;

    public FullTimeEmployee(String name, String department, double salary) {
        super(name, department);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}