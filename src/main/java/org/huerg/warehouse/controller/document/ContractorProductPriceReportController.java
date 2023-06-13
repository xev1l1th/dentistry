package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.vendorsprice.ContractorProductPrice;
import org.huerg.warehouse.data.documents.vendorsprice.ProductPrice;
import org.huerg.warehouse.service.contractor.ContractorService;
import org.huerg.warehouse.service.employee.EmployeeService;
import org.huerg.warehouse.service.product.ProductPriceService;
import org.huerg.warehouse.service.product.ProductService;
import org.huerg.warehouse.service.reports.ContractorPriceReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/contrproductprices")
@Controller
@RequiredArgsConstructor
public class ContractorProductPriceReportController {

    private final ContractorPriceReportService service;
    private final ContractorService contractorService;
    private final EmployeeService employeeService;
    private final ProductService productService;
    private final ProductPriceService productPriceServeice;

    @GetMapping()
    public String get(Model model) {
        List<ContractorProductPrice> all = service.getAll();
        model.addAttribute("cpp", all);
        return "contrPrices";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("cpp", service.getAll());
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "contrCreate";
    }

    @PostMapping("/create")
    public String postCreate(@RequestParam Product product,
                             @RequestParam Employee employee,
                             @RequestParam Contractor contractor,
                             @RequestParam Double price) {
        ProductPrice save = productPriceServeice.save(product, price);
        service.createPrice(save, LocalDateTime.now(), employee, contractor);
        return "redirect:/contrproductprices";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam ContractorProductPrice cpp) {
        model.addAttribute("contractors", contractorService.getAll());
        model.addAttribute("products", productService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("cpp", cpp);
        model.addAttribute("cppPrices", cpp.getProductPrices());
        return "contrEdit";
    }

    @GetMapping("/editprice")
    public String editPrice(Model model,
                            @RequestParam ProductPrice price) {
        model.addAttribute("price", price);
        return "editPrice";

    }

    @PostMapping("/editprice")
    public String editppp(Model model,
                            @RequestParam ProductPrice productPrice,
                          @RequestParam Double price) {
        productPrice.setPrice(price);
        productPriceServeice.update(productPrice);
        return "redirect:/contrproductprices";

    }
    @PostMapping("/edit")
    public String postEdit(@RequestParam ContractorProductPrice cpp,
                           @RequestParam Product product,
                           @RequestParam Double price) {
        cpp.addNewProductPrice(productPriceServeice.save(product, price));
        service.update(cpp);
        return "redirect:/contrproductprices";
    }

    @GetMapping("/delete")
    public String ddd(@RequestParam ContractorProductPrice cpp){
        service.delete(cpp);
        return "redirect:/contrproductprices";
    }

}
