package hutech.nguyenthanhthuan.Library.service.impl;

import hutech.nguyenthanhthuan.Library.model.City;
import hutech.nguyenthanhthuan.Library.repository.CityRepository;
import hutech.nguyenthanhthuan.Library.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}