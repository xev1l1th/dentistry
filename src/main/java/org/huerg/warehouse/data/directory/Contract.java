package org.huerg.warehouse.data.directory;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huerg.warehouse.StringUtil;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public void setName(String name) {
        if (StringUtil.isNotEmpty(name)) {
            this.name = name;
        }
    }

    public void setDescription(String description) {
        if (StringUtil.isNotEmpty(description)){
            this.description = description;
        }
    }

    public void setOwner(Contractor owner) {
        if (owner != null && owner.getId() != null) {
            this.owner = owner;
        }
    }

    public void setOrganisation(Organisation organisation) {
        if (organisation != null && organisation.getId() != null) {
            this.organisation = organisation;
        }
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Contractor owner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;

    private String description;
}
