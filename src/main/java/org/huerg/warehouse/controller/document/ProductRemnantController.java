package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.service.reports.ProductRemnantReportService;
import org.huerg.warehouse.service.reports.WarehouseRemnantInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Set;


@Controller
@RequiredArgsConstructor
@RequestMapping("/productremnant")
public class ProductRemnantController {

    private final ProductRemnantReportService service;

    @GetMapping()
    public String get(Model model) {
        Set<Map.Entry<String, Set<WarehouseRemnantInfo>>> report = service.calculateProductRemnantReport(null).entrySet();
        model.addAttribute("report", report);
        return "productremnant";
    }

}
