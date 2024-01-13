package hello.querydslexample.service.brand;

import hello.querydslexample.controller.brand.dto.SaveRequest;
import hello.querydslexample.domain.brand.Brand;
import hello.querydslexample.domain.brand.dto.BrandDto;
import hello.querydslexample.repository.brand.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveBrandService {

    private final BrandRepository brandRepository;

    public BrandDto saveBrand(SaveRequest body) {
        Brand brand = brandRepository.save(body.toEntity());
        return BrandDto.builder().brand(brand).build();
    }
}
