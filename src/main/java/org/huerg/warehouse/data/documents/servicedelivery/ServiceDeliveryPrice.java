package org.huerg.warehouse.data.documents.servicedelivery;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.data.directory.Service;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ServiceDeliveryPrice {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "price_service", joinColumns = @JoinColumn(name = "price_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Service product;

    private Double price;


}
