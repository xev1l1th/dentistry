package org.huerg.warehouse.data.documents.servicedelivery;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ServiceDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id")
    private Contractor contractor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organisation organisation;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee responsibleEmployee;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "servicedelivery_prices", joinColumns = @JoinColumn(name = "servicedelivery_id"), inverseJoinColumns = @JoinColumn(name = "serviceprice_id"))
    private Set<ServiceDeliveryPrice> serviceDeliveryPrices = new HashSet<>();
}
