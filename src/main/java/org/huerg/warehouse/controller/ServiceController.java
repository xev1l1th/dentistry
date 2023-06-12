package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.StringUtil;
import org.huerg.warehouse.data.directory.Service;
import org.huerg.warehouse.service.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("services")
@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService service;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("services", service.getAll());
        return "service";
    }

    @PostMapping
    public String create(@RequestParam String name, @RequestParam String description) {
        service.createService(name, description, null);
        return "redirect:/services";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Service service) {
        model.addAttribute("service", service);
        return "serviceEdit";
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam Service service,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String description){
        StringUtil.exec(name, service::setName);
        StringUtil.exec(description, service::setDescription);
        this.service.update(service);
        return "redirect:/services";
    }


}
