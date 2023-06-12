package org.huerg.warehouse.controller.document;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.service.reports.GoodsPriceListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("orgprices")
public class OrganizationPriceController {

    private final GoodsPriceListService service;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("info", service.getPriceList(LocalDateTime.of(1994, 4, 4, 4, 4)).getMapAsEntrySet());
        return "orgprices";
    }

}
