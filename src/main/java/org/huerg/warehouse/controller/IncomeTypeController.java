package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.IncomeType;
import org.huerg.warehouse.service.income.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/income")
public class IncomeTypeController {

    private final IncomeService incomeService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("incomes", incomeService.getAll());
        return "incomeType";
    }

    @GetMapping("/edit")
    public String edit(Model model, IncomeType incomeType) {
        model.addAttribute("incomeType", incomeType);
        return "incomeTypeEdit";
    }

    @PostMapping("/edit")
    public String editW(Model model, @RequestParam IncomeType incomeType, @RequestParam String name){
        incomeType.setName(name);
        incomeService.update(incomeType);
        return "redirect:/income";
    }

    @PostMapping
    public String create(@RequestParam String name) {
        incomeService.create(name);
        return "redirect:income";
    }

}
