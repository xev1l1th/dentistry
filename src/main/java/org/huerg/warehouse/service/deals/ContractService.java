package org.huerg.warehouse.service.deals;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Contract;
import org.huerg.warehouse.data.directory.Contractor;
import org.huerg.warehouse.data.directory.Organisation;
import org.huerg.warehouse.repo.ContractRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepo contractRepo;

    public void createContract(String name, Contractor owner, Organisation org, String description) {
        contractRepo.save(
                Contract
                        .builder()
                        .name(name)
                        .owner(owner)
                        .organisation(org)
                        .description(description)
                        .build()

        );
    }

    public List<Contract> getAll() {
        return contractRepo.findAll();
    }

    public void update(Contract contract) {
        contractRepo.save(contract);
    }

    public void delete(Contract contract) {
        contractRepo.delete(contract);
    }
}
