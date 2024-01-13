package hello.querydslexample.domain.product.variant;

import hello.querydslexample.domain.base.BaseDateTimeEntity;
import hello.querydslexample.domain.product.Product;
import hello.querydslexample.domain.product.option.Option;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "variants")
@Entity
public class Variant extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String sku;

    private Long compareAtPrice;

    private Long price;

    private Long inventoryQuantity;

    private Long brandId;

    @OneToMany(mappedBy = "variant")
    private List<Option> options = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
