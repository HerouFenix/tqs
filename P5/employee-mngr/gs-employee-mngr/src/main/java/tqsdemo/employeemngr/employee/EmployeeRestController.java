package tqsdemo.employeemngr.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees" )
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        HttpStatus status = HttpStatus.CREATED;
        Employee saved = employeeService.save(employee);
        System.out.println(saved);
        return new ResponseEntity<>(saved, status);
    }

    //@GetMapping(path="/employees", produces = "application/json")
    @GetMapping(path="/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
