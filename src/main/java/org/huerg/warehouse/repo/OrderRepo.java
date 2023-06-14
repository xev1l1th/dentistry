package org.huerg.warehouse.repo;

import org.huerg.warehouse.data.documents.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
