package org.huerg.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.huerg.warehouse.StringUtil;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.service.organization.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
@Controller
@RequestMapping("organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("organizations", organizationService.getAll());
        return "organization";
    }

    @GetMapping("/edit")
    public String getEdit(Model model, @RequestParam Organisation organisation) {
        model.addAttribute("organization", organisation);
        return "organizationEdit";
    }

    private boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    @PostMapping("/edit")
    public String postEdit(@RequestParam Organisation organisation, @RequestParam(required = false) String name, @RequestParam(required = false) String address, @RequestParam(required = false) String inn) {
        Optional.ofNullable(name).filter(StringUtil::isNotEmpty).ifPresent(organisation::setName);
        Optional.ofNullable(address).filter(StringUtil::isNotEmpty).ifPresent(organisation::setAddress);
        Optional.ofNullable(inn).filter(StringUtil::isNotEmpty).ifPresent(organisation::setInn);
        organizationService.update(organisation);
        return "redirect:/organization";
    }
    @GetMapping("/delete")
    public String postEditE(@RequestParam Organisation organisation) {
        organizationService.delete(organisation);
        return "redirect:/organization";
    }

    @PostMapping
    public String create(@RequestParam String name, @RequestParam String address, @RequestParam String inn) {
        organizationService.saveOrganization(name, inn, address);
        return "redirect:organization";
    }

}
