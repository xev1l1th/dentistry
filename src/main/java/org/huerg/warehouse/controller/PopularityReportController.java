package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.service.reports.PopularityReportService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequiredArgsConstructor
@RequestMapping("popularity")
public class PopularityReportController {
    private final PopularityReportService service;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("data", service.createReport());
        return "popularity";
    }

}
