package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.service.product.ProductService;
import org.huerg.warehouse.service.reports.ContractorPriceReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("contractorprice")
@Controller
@RequiredArgsConstructor
public class ContractorPriceReportController {

    private final ContractorPriceReportService service;
    private final ProductService productService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("info", service.createReport(productService.getAll()));
        return "contractorprice";
    }

}
