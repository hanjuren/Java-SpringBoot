package hello.querydslexample.domain.brand.dto;

import hello.querydslexample.domain.brand.Brand;
import lombok.Builder;
import lombok.Data;

@Data
public class BrandDto {

    private Long id;
    private String name;
    private String storeId;

    @Builder
    public BrandDto(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
        this.storeId = brand.getStoreId();
    }
}
