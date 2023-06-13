package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.EmployeeType;
import org.huerg.warehouse.data.directory.Gender;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("types", Arrays.asList(EmployeeType.values()));
        return "employee";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Employee employee) {
        model.addAttribute("e", employee);
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("types", Arrays.asList(EmployeeType.values()));
        return "employeeEdit";
    }

    @PostMapping("/edit")
    public String postEdit(Model model,
                           @RequestParam Employee employee,
                           @RequestParam(required = false) Gender gender,
                           @RequestParam(required = false) EmployeeType employeeType,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String position
                           ) {
        employee.setName(name);
        employee.setGender(gender);
        employee.setEmployeeType(employeeType);
        employee.setPosition(position);
        employeeService.update(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String postEdieeet(@RequestParam Employee employee
    ) {
        employeeService.delete(employee);
        return "redirect:/employee";
    }

    @PostMapping
    public String create(@RequestParam String name, @RequestParam String position, @RequestParam Gender gender, @RequestParam EmployeeType employeeType) {
        employeeService.createEmployee(name, gender, employeeType, position);
        return "redirect:/employee";
    }

}
