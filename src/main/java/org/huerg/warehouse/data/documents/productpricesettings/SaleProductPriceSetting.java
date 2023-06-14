package org.huerg.warehouse.data.documents.productpricesettings;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Employee;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SaleProductPriceSetting {

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "contractor_saleproductprice", joinColumns = @JoinColumn(name = "settings_id"), inverseJoinColumns = @JoinColumn(name = "saleproductprice_id"))
    private Set<SaleProductPrice> productPrices = new HashSet<>();

    public void addNewProductPrice(SaleProductPrice saveSale) {
        getProductPrices().add(saveSale);
    }
}
