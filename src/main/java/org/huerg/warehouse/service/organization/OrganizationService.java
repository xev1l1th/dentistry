package org.huerg.warehouse.service.organization;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.repo.OrganizationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepo organizationRepo;

    public void saveOrganization(String name, String inn, String address) {
        organizationRepo
                .save(Organisation
                        .builder()
                        .address(address)
                        .inn(inn)
                        .createdTime(LocalDateTime.now())
                        .name(name)
                        .build());
    }

    public List<Organisation> getAll() {
        return organizationRepo.findAll();
    }

    public void update(Organisation organisation) {
        organizationRepo.save(organisation);
    }
}
