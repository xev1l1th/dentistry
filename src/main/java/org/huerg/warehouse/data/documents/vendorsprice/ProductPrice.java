package org.huerg.warehouse.data.documents.vendorsprice;

import javax.persistence.*;
import lombok.*;
import org.huerg.warehouse.data.directory.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(of = "id")
//цена за продукт
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Double price;



}
