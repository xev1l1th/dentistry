package org.huerg.warehouse.data.documents.vendorsprice;

import javax.persistence.*;
import lombok.*;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.Product;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(of = "id")
@ToString
//цены поставщиков
public class ContractorProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id")
    private Contractor contractor;

    @CreatedDate
    private LocalDateTime createdDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee responsibleEmployee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "contractor_productprice", joinColumns = @JoinColumn(name = "contractor_id"), inverseJoinColumns = @JoinColumn(name = "producrprice_id"))
    private Set<ProductPrice> productPrices = new HashSet<>();

    public void addNewProductPrice(ProductPrice productPrice) {
        productPrices.add(productPrice);
    }
}
