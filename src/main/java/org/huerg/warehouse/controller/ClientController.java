package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.service.order.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("all", clientService.getAll());
        return "client";
    }

    @PostMapping
    public String post(@RequestParam(required = false) String name,
                       @RequestParam(required = false) String surname,
                       @RequestParam(required = false) String patronymicName,
                       @RequestParam(required = false) String phone
                       ) {
        clientService.create(name, surname, patronymicName, phone);
        return "redirect:/client";
    }


}
