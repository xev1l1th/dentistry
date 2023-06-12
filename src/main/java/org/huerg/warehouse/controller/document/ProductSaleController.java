package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.*;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPriceSetting;
import org.huerg.warehouse.data.documents.productreceipt.ProductReceipt;
import org.huerg.warehouse.data.documents.productsale.ProductSale;
import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.huerg.warehouse.data.documents.vendorsprice.ContractorProductPrice;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.huerg.warehouse.service.organization.OrganizationService;
import org.huerg.warehouse.service.product.ProductPriceService;
import org.huerg.warehouse.service.product.ProductReceiptService;
import org.huerg.warehouse.service.product.ProductService;
import org.huerg.warehouse.service.reports.ContractorPriceReportService;
import org.huerg.warehouse.service.reports.SaleProductPriceSettingsService;
import org.huerg.warehouse.service.sale.ProductSaleService;
import org.huerg.warehouse.service.warhouse.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/sale")
@RequiredArgsConstructor
public class ProductSaleController {


    private final SaleProductPriceSettingsService saleService;
    private final ContractorService contractorService;
    private final EmployeeService employeeService;
    private final OrganizationService organizationService;
    private final WarehouseService warehouseService;
    private final ProductSaleService productSaleService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("all", productSaleService.getAll());
        model.addAttribute("times", saleService.getAllDates());
        return "sale";
    }

    @GetMapping("/create")
    public String getC(Model model, @RequestParam String time) {
        LocalDateTime parse = LocalDateTime.parse(time);
        Set<SaleProductPrice> byDate = saleService.getByDate(parse).getProductPrices();
        model.addAttribute("orgs", organizationService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("warehouses", warehouseService.getAll());
        model.addAttribute("pp", byDate);
        model.addAttribute("date", parse.toString());
        return "createSale";
    }

    @PostMapping("/create")
    public String postCreate(@RequestParam String time,
                             @RequestParam Long count,
                             @RequestParam Contractor contractor,
                             @RequestParam Employee employee,
                             @RequestParam Organisation organisation,
                             @RequestParam Warehouse warehouse,
                             @RequestParam SaleProductPrice productPrice) {
        productSaleService.save(time, count, contractor, employee, organisation, warehouse, productPrice);
        return "redirect:/sale";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam ProductSale productReceipt) {
        var localDateTime = productReceipt.getLocalDateTime();
        Set<SaleProductPrice> byDate = saleService.getByDate(localDateTime).getProductPrices();
        model.addAttribute("receipt", productReceipt);
        model.addAttribute("orgs", organizationService.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("warehouses", warehouseService.getAll());
        model.addAttribute("pp", byDate);
        return "editSale";
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam ProductSale productReceipt,
                           @RequestParam Long count,
                           @RequestParam SaleProductPrice productPrice) {

        productSaleService.update(productReceipt, count, productPrice);
        return "redirect:/sale";
    }

}
