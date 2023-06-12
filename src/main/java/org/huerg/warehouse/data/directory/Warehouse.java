package org.huerg.warehouse.data.directory;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.StringUtil;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public void setName(String name) {
        if (StringUtil.isNotEmpty(name)) {
            this.name = name;
        }
    }

    public void setResponsibleEmployee(Employee employee) {
        if (employee != null && employee.getId() != null ) {
            this.responsibleEmployee = employee;
        }
    }

    @Enumerated(EnumType.STRING)
    private WarehouseType documentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee responsibleEmployee;
}
