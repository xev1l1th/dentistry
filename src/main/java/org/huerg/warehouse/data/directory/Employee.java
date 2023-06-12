package org.huerg.warehouse.data.directory;

import lombok.*;
import org.huerg.warehouse.StringUtil;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(of = "id")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public void setName(String name) {
        if (StringUtil.isNotEmpty(name)) {
            this.name = name;
        }
    }

    public void setPosition(String position) {
        if (StringUtil.isNotEmpty(position)) {
            this.position = position;
        }
    }

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String position;


    //todo
    private LocalDateTime birthDate;


}
