package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contract;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.deals.ContractService;
import org.huerg.warehouse.service.organization.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("contracts")
public class ContractController {

    private final ContractService contractService;
    private final ContractorService contractorService;
    private final OrganizationService organizationService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("contracts", contractService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("organizations", organizationService.getAll());
        return "contract";
    }


    @GetMapping("/edit")
    public String editContract(Model model, @RequestParam Contract contract) {
        model.addAttribute("contract", contract);
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("organizations", organizationService.getAll());
        return "contractEdit";
    }

    @PostMapping("/edit")
    public String contractEdit(Model model,
                               @RequestParam Contract contract,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String description,
                               @RequestParam(required = false) Contractor contractor,
                               @RequestParam(required = false) Organisation organisation) {
        contract.setName(name);
        contract.setDescription(description);
        contract.setOrganisation(organisation);
        contract.setOwner(contractor);
        contractService.update(contract);
        return "redirect:/contracts";
    }
    @PostMapping
    public String create(@RequestParam String name, @RequestParam String description, @RequestParam Contractor contractor, @RequestParam Organisation organisation) {
        contractService.createContract(name, contractor, organisation, description);
        return "redirect:/contracts";
    }

}
