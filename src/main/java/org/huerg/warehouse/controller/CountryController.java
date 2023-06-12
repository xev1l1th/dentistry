package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Country;
import org.huerg.warehouse.service.country.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "country";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Country country) {
        model.addAttribute("country", country);
        return "countryEdit";
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam Country country, @RequestParam(required = false) String name, @RequestParam(required = false) String inn) {
        country.setName(name);
        countryService.update(country);
        return "redirect:/country";
    }

    @PostMapping
    public String create(@RequestParam String name) {
        countryService.createCountry(name);
        return "redirect:/country";
    }
}
