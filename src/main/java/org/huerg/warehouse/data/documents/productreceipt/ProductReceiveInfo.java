package org.huerg.warehouse.data.documents.productreceipt;

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
public class ProductReceiveInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Double receivePrice;

    private Long receiptCount;

    private Double totalSum;

    public void calcSum() {
        this.totalSum = receivePrice * receiptCount;
    }
}
