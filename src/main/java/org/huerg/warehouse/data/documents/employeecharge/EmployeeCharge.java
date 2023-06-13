package org.huerg.warehouse.data.documents.employeecharge;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.data.directory.Employee;
import org.huerg.warehouse.data.directory.WorkSchedule;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EmployeeCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee responsibleEmployee;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workschedule_id", referencedColumnName = "id")
    private WorkSchedule workSchedule;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeChargeType_id", referencedColumnName = "id")
    private EmployeeChargeType employeeChargeType;

    private LocalDateTime start;

    private LocalDateTime end;

    private Double income;

}
