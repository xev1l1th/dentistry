package org.huerg.warehouse.controller;


import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.StringUtil;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("products", productService.getAll());
        return "product";
    }


    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Product product) {
        model.addAttribute("product", product);
        return "productEdit";
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam Product product,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String description){
        StringUtil.exec(name, product::setName);
        StringUtil.exec(description, product::setDescription);
        productService.update(product);
        return "redirect:/product";

    }

    @GetMapping("/delete")
    public String postEdit(@RequestParam Product product){
        productService.delete(product);
        return "redirect:/product";

    }
    @PostMapping
    public String create(@RequestParam String name, @RequestParam String description) {
        productService.create(name, description);
        return "redirect:/product";
    }



}
