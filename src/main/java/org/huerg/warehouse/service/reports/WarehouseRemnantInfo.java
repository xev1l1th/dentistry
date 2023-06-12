package org.huerg.warehouse.service.reports;

import lombok.*;

import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class WarehouseRemnantInfo {

   private String warehouse;
   private Map<String, Integer> productInfo;
   private int total;

   public WarehouseRemnantInfo(String warehouse, Map<String, Integer> productInfo) {
      this.warehouse = warehouse;
      this.productInfo = productInfo;
      this.total = productInfo
              .values()
              .stream()
              .reduce(0, Integer::sum);

   }

   public void putProduct(String name, int count) {
      productInfo.put(name, productInfo.getOrDefault(name, 0) + count);
      total += count;
   }

   public Set<Map.Entry<String, Integer>> getProductInfoAsSet() {
      return productInfo.entrySet();
   }
}
