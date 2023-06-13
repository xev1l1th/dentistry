package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPriceSetting;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.huerg.warehouse.service.product.ProductService;
import org.huerg.warehouse.service.reports.SaleProductPriceSettingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/saleprices")
@Controller
@RequiredArgsConstructor
public class SaleProductPriceController {


    private final SaleProductPriceSettingsService service;
    private final ContractorService contractorService;
    private final ProductService productService;
    private final EmployeeService employeeService;

    @GetMapping()
    public String get(Model model) {
        List<SaleProductPriceSetting> all = service.getAll();
        model.addAttribute("spp", all);
        return "salePrices";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("cpp", service.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "saleCreate";
    }

    @PostMapping("/create")
    public String postCreate(@RequestParam Product product,
                             @RequestParam Employee employee,
                             @RequestParam Contractor contractor,
                             @RequestParam Double price) {
        SaleProductPrice save = service.saveSale(product, price);
        service.createSaleIngo(save, LocalDateTime.now(), employee, contractor);
        return "redirect:/saleprices";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam SaleProductPriceSetting spp) {
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("spp", spp);
        model.addAttribute("sppPrices", spp.getProductPrices());
        return "saleEdit";
    }

    @GetMapping("/editprice")
    public String editPrice(Model model,
                            @RequestParam SaleProductPrice price) {
        model.addAttribute("price", price);
        return "editPrice";

    }

    @PostMapping("/editprice")
    public String editppp(Model model,
                          @RequestParam SaleProductPrice productPrice,
                          @RequestParam Double price) {
        productPrice.setPrice(price);
        service.update(productPrice);
        return "redirect:/saleprices";

    }
    @PostMapping("/edit")
    public String postEdit(@RequestParam SaleProductPriceSetting spp,
                           @RequestParam Product product,
                           @RequestParam Double price) {
        spp.addNewProductPrice(service.saveSale(product, price));
        service.updateSale(spp);
        return "redirect:/saleprices";
    }

    @GetMapping("/delete")
    public String postDelete(@RequestParam SaleProductPriceSetting spp) {
        service.deleteSale(spp);
        return "redirect:/saleprices";
    }

}
