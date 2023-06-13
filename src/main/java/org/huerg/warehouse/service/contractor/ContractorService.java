package org.huerg.warehouse.service.contractor;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.ContractorType;
import org.huerg.warehouse.data.directory.Country;
import org.huerg.warehouse.repo.ContractorRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractorService {

    private final ContractorRepo contractorRepo;

    public void createContractor(String name, ContractorType type, String inn, Country country) {
        contractorRepo.save(
                Contractor
                        .builder()
                        .name(name)
                        .inn(inn)
                        .country(country)
                        .createdTime(LocalDateTime.now())
                        .contractorType(type)
                        .build()
        );
    }

    public List<Contractor> getAll() {
        return contractorRepo.findAll();
    }

    public void update(Contractor contractor) {
        contractorRepo.save(contractor);
    }

    public void delete(Contractor contractor) {
        contractorRepo.delete(contractor);
    }
}
