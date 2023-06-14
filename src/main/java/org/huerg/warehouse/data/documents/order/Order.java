package org.huerg.warehouse.data.documents.order;

import lombok.*;
import org.huerg.warehouse.data.directory.Client;
import org.huerg.warehouse.data.directory.Product;
import org.huerg.warehouse.data.documents.productpricesettings.SaleProductPrice;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "orrders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productsalepricee_id", referencedColumnName = "id")
    private SaleProductPrice product;

    private Long count;

    @Builder.Default
    private boolean isCommitted = false;
}
