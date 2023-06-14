package org.huerg.warehouse.service.order;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.huerg.warehouse.data.directory.Client;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.directory.Warehouse;
import org.huerg.warehouse.data.documents.order.Order;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;
import org.huerg.warehouse.data.documents.productsale.ProductSalePriceInfo;
import org.huerg.warehouse.repo.*;
import org.huerg.warehouse.service.sale.ProductSaleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final ClientRepo clientRepo;
    private final ProductSaleService productSaleService;

    public void createOrder(Client client, SaleProductPrice product, Long count) {
        orderRepo.save(
                Order
                        .builder()
                        .client(client)
                        .product(product)
                        .count(count)
                        .build()
        );
    }


    private final ContractorRepo contractorRepo;
    private final WarehouseRepo warehouseRepo;
    private final OrganizationRepo orgRepo;
    private final EmployeeRepo employeeRepo;

    public void commitOrder(Order order) {
        productSaleService.save(
                LocalDateTime.now().toString(),
                order.getCount(),
                contractorRepo.findAll().stream().findAny().get(),
                employeeRepo.findAll().stream().findAny().get(),
                orgRepo.findAll().stream().findAny().get(),
                warehouseRepo.findAll().stream().findAny().get(),
                order.getProduct(),
                true
        );
        order.setCommitted(true);
        orderRepo.save(order);
    }

    public List<Order> getAllUncommitted() {
        return orderRepo
                .findAll()
                .stream()
                .filter(o -> !o.isCommitted())
                .toList();
    }

    public List<Order> getAllCommitted() {
        return orderRepo
                .findAll()
                .stream()
                .filter(Order::isCommitted)
                .toList();
    }
}
