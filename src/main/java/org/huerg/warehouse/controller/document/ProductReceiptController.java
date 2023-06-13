package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.*;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.huerg.warehouse.data.documents.vendorsprice.ContractorProductPrice;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.huerg.warehouse.service.organization.OrganizationService;
import org.huerg.warehouse.service.product.ProductReceiptService;
import org.huerg.warehouse.service.reports.ContractorPriceReportService;
import org.huerg.warehouse.service.warhouse.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Set;

@Controller
@RequestMapping("/receipt")
@RequiredArgsConstructor
public class ProductReceiptController {

    private final ProductReceiptService productReceiptService;
    private final ContractorService contractorService;
    private final EmployeeService employeeService;
    private final OrganizationService organizationService;
    private final WarehouseService warehouseService;
    private final ContractorPriceReportService contractorPriceReportService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("all", productReceiptService.getAll());
        model.addAttribute("times", contractorPriceReportService.getAllDates());
        return "receipt";
    }

    @GetMapping("/create")
    public String getC(Model model, @RequestParam String time) {
        LocalDateTime parse = LocalDateTime.parse(time);
        Set<ProductPrice> byDate = contractorPriceReportService.getByDate(parse).getProductPrices();
        model.addAttribute("orgs", organizationService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("warehouses", warehouseService.getAll());
        model.addAttribute("pp", byDate);
        model.addAttribute("date", parse.toString());
        return "receiptCreate";
    }

    @PostMapping("/create")
    public String postCreate(@RequestParam String time,
                             @RequestParam Long count,
                             @RequestParam Contractor contractor,
                             @RequestParam Employee employee,
                             @RequestParam Organisation organisation,
                             @RequestParam Warehouse warehouse,
                             @RequestParam ProductPrice productPrice) {
        productReceiptService.save(time, count, contractor, employee, organisation, warehouse, productPrice);
        return "redirect:/receipt";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam ProductReceipt productReceipt) {
        var localDateTime = productReceipt.getLocalDateTime();
        Set<ProductPrice> byDate = contractorPriceReportService.getByDate(localDateTime).getProductPrices();
        model.addAttribute("receipt", productReceipt);
        model.addAttribute("orgs", organizationService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("warehouses", warehouseService.getAll());
        model.addAttribute("pp", byDate);
        return "editReceipt";
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam ProductReceipt productReceipt,
                           @RequestParam Long count,
                           @RequestParam ProductPrice productPrice) {

        productReceiptService.update(productPrice, count, productReceipt);
        return "redirect:/receipt";
    }

    @GetMapping("/delete")
    public String postEditP(@RequestParam ProductReceipt productReceipt) {
        productReceiptService.delete(productReceipt);
        return "redirect:/receipt";
    }

}
