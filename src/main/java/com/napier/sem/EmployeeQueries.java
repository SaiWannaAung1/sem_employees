package com.napier.sem;

import java.util.ArrayList;

public class EmployeeQueries {

    static String basicQuery = "SELECT employees.emp_no, employees.first_name, employees.last_name, " +
            "titles.title, salaries.salary, departments.dept_name, dept_manager.emp_no FROM " +
            "employees, salaries, titles, departments, dept_emp, dept_manager WHERE employees" +
            ".emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' AND titles.emp_no " +
            "= employees.emp_no AND titles.to_date = '9999-01-01' AND dept_emp.emp_no = " +
            "employees.emp_no AND dept_emp.to_date = '9999-01-01' AND departments.dept_no = " +
            "dept_emp.dept_no AND dept_manager.dept_no = dept_emp.dept_no AND dept_manager" +
            ".to_date = '9999-01-01' ";

    public static void printEmployees(ArrayList<Employee> employees) {
        // Check employees is not null
        if (employees == null) {
            System.out.println("No employees");
            return;
        }


        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last " +
                "Name", "Salary"));
        // Loop over all employees in the list
        for (Employee emp : employees) {
            if (emp == null) continue;
            String emp_string = String.format("%-10s %-15s %-20s %-8s", emp.emp_no,
                    emp.first_name, emp.last_name,
                    emp.salary);
            System.out.println(emp_string);
        }
    }

    /**
     * All current employees ordered by emp_no
     * @return
     */
    public static String getAllSalariesSql() {
        String strSelect = basicQuery + "ORDER BY employees.emp_no ASC";
        return strSelect;
    }

    /**
     * Single current Employee based on emp_no
     * @param emp_no
     * @return
     */
    public static String getEmployeeSql(int emp_no) {
        String strSelect = basicQuery + "AND employees.emp_no = '" + emp_no + "'";
        return strSelect;
    }
}
