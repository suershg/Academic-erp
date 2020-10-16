package org.iiitb.service.impl;

import org.iiitb.bean.Employee;
import org.iiitb.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> getall()
    {
        return employeeDao.getall();
    }
}
