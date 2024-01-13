package hello.querydslexample.controller.brand;

import hello.querydslexample.controller.brand.dto.SaveRequest;
import hello.querydslexample.domain.brand.dto.BrandDto;
import hello.querydslexample.service.brand.SaveBrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("brands")
@RequiredArgsConstructor
public class BrandController {

    private final SaveBrandService saveBrandService;

    @GetMapping("")
    public ResponseEntity<?> getBrands(Pageable pageable) {
        log.info("pageable: {}", pageable);
        return ResponseEntity.ok().body("Hello");
    }

    @PostMapping("")
    public ResponseEntity<?> saveBrand(@RequestBody @Valid SaveRequest body) {
        BrandDto result = saveBrandService.saveBrand(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
