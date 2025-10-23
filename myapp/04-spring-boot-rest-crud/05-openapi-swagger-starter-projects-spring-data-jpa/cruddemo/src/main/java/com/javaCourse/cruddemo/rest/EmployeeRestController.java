package com.javaCourse.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.javaCourse.cruddemo.entity.Employee;
import com.javaCourse.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // quick and dirty: inject employee dao (use constructor injection)
    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    public EmployeeRestController (EmployeeService employeeService, ObjectMapper objectMapper){
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){throw new RuntimeException("Employee id not found - " + employeeId);}

        return employee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // also just in case user passes an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);

        return employeeService.save(employee);
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }

    // add mapping for PATCH /employees/{employeeID} - patch employee ... partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee updateEmployeeFields(@PathVariable int employeeId,
                                         @RequestBody Map<String, Object> patchPayload){

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // throw exception if request body contains "id" key
        if(patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id is not allowed in request body - " + employeeId);
        }

        return employeeService.save(apply(patchPayload, tempEmployee));
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }


    // add mapping for DELETE /employees/{employeeID} - delete a single employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        // throw exception if null

        if(employee == null){throw new RuntimeException("Employee id not found - " + employeeId);}

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

    // add mapping for DELETE /employees - delete all employees
    @DeleteMapping("/employees")
    public String deleteAllEmployee(){

        return "Deleted all employees";
    }
}
