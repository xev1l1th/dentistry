package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.service.reports.ServiceReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("servicereport")
public class ServiceReportServiceController {

    private final ServiceReportService service;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("data", service.createReport());
        return "servicereport";
    }
}
