package org.huerg.warehouse.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.WorkSchedule;
import org.huerg.warehouse.service.workschedule.WorkScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workschedule")
@RequiredArgsConstructor
public class WorkScheduleController {

    private final WorkScheduleService workScheduleService;


    @GetMapping
    public String get(Model model) {
        model.addAttribute("schedules", workScheduleService.getAll());
        return "workSchedule";
    }

    @PostMapping
    public String create(@RequestParam String name) {
        workScheduleService.createWorkScheduleType(name);
        return "redirect:/workschedule";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, WorkSchedule workSchedule) {
        model.addAttribute("workschedule", workSchedule);
        return "workScheduleEditor";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam WorkSchedule workSchedule, @RequestParam String name) {
        workSchedule.setName(name);
        workScheduleService.update(workSchedule);
        return "redirect:/workschedule";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam WorkSchedule workSchedule) {
        workScheduleService.delete(workSchedule);
        return "redirect:/workschedule";
    }

}
