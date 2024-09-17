package com.mongo.employee_CRUD.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongo.employee_CRUD.entity.Employee;
import com.mongo.employee_CRUD.service.EmployeeService;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	
	  // Show employee list
		/*
		 * @GetMapping("/") public String showList(Model model) {
		 * model.addAttribute("employee", new Employee()); return "index"; }
		 */
    
 // Show form for creating a new employee   
    @GetMapping("/new")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }
    
 // Find all employees
    @GetMapping("/")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        System.out.println("Fetched employees: " + employees);
        model.addAttribute("employees", employees);
        
        return "index";
    }

    // Create or update employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    

    // Edit employee
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable String id, Model model) {
        Employee employee = employeeService.findEmployeeById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

   

  

}
