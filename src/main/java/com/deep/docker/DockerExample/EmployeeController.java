package com.deep.docker.DockerExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/save")
    public ResponseEntity<List<Employee>> saveEmp(){
        List<Employee> employees = employeeService.saveEmployees();
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Employee> getEmp(@PathVariable("name") String name){
        Employee employee = employeeService.getEmployee(name);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
