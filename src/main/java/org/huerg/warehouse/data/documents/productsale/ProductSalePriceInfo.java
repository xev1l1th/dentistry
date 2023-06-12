package org.huerg.warehouse.data.documents.productsale;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.data.directory.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProductSalePriceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Double price;

    private Long count;

    private Double sum;

    public void calcSum() {
        this.sum = price * count;
    }
}
