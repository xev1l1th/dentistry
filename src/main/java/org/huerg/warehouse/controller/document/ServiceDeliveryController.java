package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.data.directory.Service;
import org.huerg.warehouse.data.documents.servicedelivery.ServiceDelivery;
import org.huerg.warehouse.data.documents.servicedelivery.ServiceDeliveryPrice;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.huerg.warehouse.service.organization.OrganizationService;
import org.huerg.warehouse.service.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/servicedelivery")
@RequiredArgsConstructor
@Controller
public class ServiceDeliveryController {

    private final OrganizationService organizationService;
    private final ContractorService contractorService;
    private final EmployeeService employeeService;
    private final ServiceService service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("all", service.getAllServiceDelivery());
        return "serviceDelivery";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("orgs", organizationService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("services", service.getAll());
        return "serviceDeliveryCreate";
    }

    @PostMapping("/create")
    public String postCreate(@RequestParam Contractor contractor,
                             @RequestParam Organisation organisation,
                             @RequestParam Employee employee,
                             @RequestParam Service service,
                             @RequestParam Double price) {
        ServiceDeliveryPrice serviceDeliveryPrice = this.service.saveServiceDeliveryPrice(service, price);
        this.service.createServiceDelivery(contractor, organisation, employee, serviceDeliveryPrice);
        return "redirect:/servicedelivery";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam ServiceDelivery serviceDelivery) {
        model.addAttribute("sd", serviceDelivery);
        model.addAttribute("sdpPrices", serviceDelivery.getServiceDeliveryPrices().stream().toList());
        model.addAttribute("orgs", organizationService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("services", service.getAll());
        return "serviceDeliveryEdit";
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam ServiceDelivery serviceDelivery,
                           @RequestParam Service service,
                           @RequestParam Double price) {
        var serviceDeliveryPrice = this.service.saveServiceDeliveryPrice(service, price);
        serviceDelivery.getServiceDeliveryPrices().add(serviceDeliveryPrice);
        this.service.update(serviceDelivery);
        return "redirect:/servicedelivery";
    }

    @GetMapping("/editprice")
    public String getEditPrice(Model model, @RequestParam ServiceDeliveryPrice serviceDeliveryPrice) {
        model.addAttribute("sdp", serviceDeliveryPrice);
        return "serviceDeliveryPriceEdit";
    }

    @PostMapping("/editprice")
    public String postEditPrice(@RequestParam ServiceDeliveryPrice serviceDeliveryPrice,
                                @RequestParam Double price) {

        serviceDeliveryPrice.setPrice(price);
        service.update(serviceDeliveryPrice);
        return "redirect:/servicedelivery";
    }



}
