package hutech.nguyenthanhthuan.Library.service.impl;

import hutech.nguyenthanhthuan.Library.model.Country;
import hutech.nguyenthanhthuan.Library.repository.CountryRepository;
import hutech.nguyenthanhthuan.Library.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
