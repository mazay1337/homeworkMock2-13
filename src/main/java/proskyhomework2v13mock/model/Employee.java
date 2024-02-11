package proskyhomework2v13mock.model;

import java.util.Objects;

public class Employee {

    private final  String firstName;
    private final String lastName;
    private int salary;
    private int departmentId;

    public Employee(String firstName, String lastName, int salary, int departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId
                && firstName.equals(employee.firstName)
                && lastName.equals(employee.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId);
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s из отдела № %d с зарплатой %d",
                lastName, firstName, departmentId,salary);
    }
}