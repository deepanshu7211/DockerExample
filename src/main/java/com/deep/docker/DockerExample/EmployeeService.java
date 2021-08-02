package com.deep.docker.DockerExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employees = Arrays.asList(new Employee("abc"),new Employee("bcd")
            ,new Employee("def"));

    public List<Employee> saveEmployees(){
      for(Employee employee : employees){
          employeeRepository.save(employee);
      }
      return employees;
    }

    public Employee getEmployee(String name){
        Employee employee = employeeRepository.findByName(name);
        return employee;
    }
}
