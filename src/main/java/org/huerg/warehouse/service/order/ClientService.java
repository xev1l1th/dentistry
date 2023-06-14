package org.huerg.warehouse.service.order;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Client;
import org.huerg.warehouse.repo.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepo clientRepo;

    public void create(String name, String surname, String patronymicName, String number) {
        clientRepo
                .save(Client
                        .builder()
                        .phoneNumber(number)
                        .surname(surname)
                        .name(name)
                        .patronymicName(patronymicName)
                        .build());
    }

    public List<Client> getAll() {
        return clientRepo.findAll();
    }
}
