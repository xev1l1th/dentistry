package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Warehouse;
import org.huerg.warehouse.data.directory.WarehouseType;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.huerg.warehouse.service.warhouse.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@RequestMapping("warehouse")
@Controller
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final EmployeeService employeeService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("warehouses", warehouseService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("warehouseType", Arrays.asList(WarehouseType.values()));
        return "warehouse";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Warehouse warehouse) {
        model.addAttribute("warehouse", warehouse);
        model.addAttribute("employee", employeeService.getAll());
        model.addAttribute("warehouseType", Arrays.asList(WarehouseType.values()));
        return "warehouseEdit";
    }

    @PostMapping("/edit")
    public String putEdit(Model model,
                          @RequestParam Warehouse warehouse,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) Employee employee,
                          @RequestParam(required = false) WarehouseType warehouseType) {
        warehouse.setName(name);
        warehouse.setResponsibleEmployee(employee);
        warehouse.setDocumentType(warehouseType);
        warehouseService.update(warehouse);
        return "redirect:/warehouse";
    }

    @PostMapping
    public String create(@RequestParam String name,
                         @RequestParam Employee employee,
                         @RequestParam WarehouseType warehouseType) {
        warehouseService.createWarehouse(name, employee, warehouseType);
        return "redirect:/warehouse";
    }

}
