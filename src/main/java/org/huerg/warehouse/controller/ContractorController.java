package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.StringUtil;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.ContractorType;
import org.huerg.warehouse.data.directory.Country;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.country.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("contractors")
public class ContractorController {

    private final ContractorService contractorService;
    private final CountryService countryService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "contractor";
    }

    @GetMapping("edit")
    public String editCountry(Model model, @RequestParam Contractor contractor) {
        model.addAttribute("contractor", contractor);
        model.addAttribute("countries", countryService.getAll());
        return "contractorEdit";
    }

    private boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }


    @PostMapping("/edit")
    public String postEdit(Model model, @RequestParam Contractor contractor, @RequestParam(required = false) Country country, @RequestParam(required = false) String name, @RequestParam(required = false) String inn){
        Optional.ofNullable(country).filter(c -> c.getId() != null).ifPresent(contractor::setCountry);
        Optional.ofNullable(name).filter(StringUtil::isNotEmpty).ifPresent(contractor::setName);
        StringUtil.exec(inn, contractor::setInn);
        contractorService.update(contractor);
        return "redirect:/contractors";
    }

    @PostMapping
    public String create(@RequestParam String name, @RequestParam(required = false) String inn, @RequestParam Country country) {
        contractorService.createContractor(name, ContractorType.LOX, inn, country);
        return "redirect:/contractors";
    }

}
