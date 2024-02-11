package proskyhomework2v13mock.servie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import proskyhomework2v13mock.exceptions.EmployeeNotFoundException;
import proskyhomework2v13mock.service.DepartmentServiceImpl;
import proskyhomework2v13mock.service.EmployeeService;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static proskyhomework2v13mock.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeWhithMaxSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyEmployeesList() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalsryInEmptyEmployeesList() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryInEmptyDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnAllEmployeesByDepartmentWhenEmployeesExist() {
        when(employeeService.findAll()).thenReturn(DIFFRENT_DEPARTMENT_EMPLOYEES);
        assertEquals(DEPARTMENT_MAP, out.findEmployeesByDepartment());
    }

    @Test
    public void shouldReturnEmptyMapWhenEmployeeDontExist() {
        when(employeeService.findAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), out.findEmployeesByDepartment());
    }

    @Test
    public void shouldReturnEmployeesByDepartmentWhenDepartmentIsCorrectAndEmployeesExistThere() {
        when(employeeService.findAll()).thenReturn(DIFFRENT_DEPARTMENT_EMPLOYEES);
        assertEquals(singletonList(MIN_SALARY_EMPLOYEE), out.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFRENT_DEPARTMENT_EMPLOYEE), out.findEmployeesByDepartment(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmptyListWhenEmployeesDontFOndInDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);
        assertEquals(emptyList(), out.findEmployeesByDepartment(BAD_DEPARTMENT_ID));
    }
}