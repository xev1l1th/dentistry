package org.huerg.warehouse.data.directory;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Builder.Default
    private String name = "";
    @Builder.Default
    private String surname = "";
    @Builder.Default
    private String patronymicName = "";

    private String phoneNumber;

    public String getFullName() {
        return String.format("%s %s %s", name, surname, patronymicName);
    }
}
