package hello.querydslexample.controller.brand.dto;

import hello.querydslexample.domain.brand.Brand;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SaveRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String storeId;

    public Brand toEntity() {
        return Brand.builder()
                .name(name)
                .storeId(storeId)
                .build();
    }
}
