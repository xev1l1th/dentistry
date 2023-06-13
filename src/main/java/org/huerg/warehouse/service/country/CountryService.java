package org.huerg.warehouse.service.country;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.directory.Country;
import org.huerg.warehouse.repo.CountryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepo countryRepo;

    public void createCountry(String name) {
        countryRepo.save(
                Country
                        .builder()
                                .name(name).build()
        );
    }

    public List<Country> getAll() {
        return countryRepo.findAll();
    }

    public void update(Country country) {
        countryRepo.save(country);
    }

    public void delete(Country country) {
        countryRepo.delete(country);
    }
}
