package hello.querydslexample.repository.brand;


import hello.querydslexample.domain.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByStoreId(String storeId);
}
