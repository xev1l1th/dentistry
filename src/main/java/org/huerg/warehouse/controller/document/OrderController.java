package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Client;
import org.huerg.warehouse.data.documents.order.Order;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPriceSetting;
import org.huerg.warehouse.repo.ClientRepo;
import org.huerg.warehouse.service.order.OrderService;
import org.huerg.warehouse.service.reports.SaleProductPriceSettingsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final SaleProductPriceSettingsService service;
    private final OrderService orderService;
    private final ClientRepo clientRepo;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("clients", clientRepo.findAll());
        Set<SaleProductPrice> all = service.getAll()
                .stream()
                .map(SaleProductPriceSetting::getProductPrices)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        model.addAttribute("all", all);
        model.addAttribute("orders", orderService.getAllUncommitted());
        return "order";
    }

    @PostMapping
    public String createOrder(@RequestParam Client client, @RequestParam Long count, @RequestParam SaleProductPrice product) {
        orderService.createOrder(client, product, count);
        return "redirect:/order";
    }

    @GetMapping("commit")
    public String commitOrder(Order order) {
        orderService.commitOrder(order);
        return "redirect:/order";
    }

    @GetMapping("report")
    public String orderReport(Model model) {
        model.addAttribute("all", orderService.getAllCommitted());
        return "orderReport";
    }

}
