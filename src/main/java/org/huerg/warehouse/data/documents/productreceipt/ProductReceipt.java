package org.huerg.warehouse.data.documents.productreceipt;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.data.directory.Warehouse;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime localDateTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee responsibleEmployee;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id")
    private Contractor contractor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warhouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "receipt_productpriceinfo", joinColumns = @JoinColumn(name = "receipt_id"), inverseJoinColumns = @JoinColumn(name = "producrprice_id"))
    private Set<ProductReceiveInfo> contractorProductPrice = new HashSet<>();

    public void addProductReceipt(ProductReceiveInfo save) {
        getContractorProductPrice().add(save);
    }
}
