package com.example.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.employee;
import com.example.crud.repository.employeerepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class employeecontroller {
	
	@Autowired
	private employeerepository emprepo;
	
	
	@GetMapping("/employees")
	public List<employee> getAllEmployees(){
		return emprepo.findAll();
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Map<String, Object>> createEmployee(@RequestBody employee employee) {
	    employee createdEmployee = emprepo.save(employee);

	    Map<String, Object> response = new HashMap<>();
	    response.put("success", true);
	    response.put("message", "Employee created successfully");
	    response.put("employee", createdEmployee);

	    return ResponseEntity.ok(response);
	}

	
	@GetMapping("/employees/{id}")
	public ResponseEntity<employee> getEmployeeById(@PathVariable Long id) {
	    employee employee = emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid id: " + id));
	    return ResponseEntity.ok(employee);
	}
	
	
	@PutMapping("/employees/{id}")
    public ResponseEntity<employee> updateEmp(@PathVariable Long id, @RequestBody employee empdetails){
    	employee emp = emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid id:" + id));
    	emp.setEname(empdetails.getEname());
    	emp.setEaddress(empdetails.getEaddress());
    	emp.setEemail(empdetails.getEemail());
    	emp.setEphone(empdetails.getEphone());
    	emp.setEtype(empdetails.getEtype());
    	emp.setDid(empdetails.getDid());
    	emp.setPid(empdetails.getPid());
    	emp.setEjoiningdate(empdetails.getEjoiningdate());
        
        employee updatedemp = emprepo.save(emp);
        return ResponseEntity.ok(updatedemp);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmp(@PathVariable Long id) {
    	employee employee = emprepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid id" + id));
    	emprepo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
