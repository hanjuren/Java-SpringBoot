package hello.querydslexample.domain.product;

import hello.querydslexample.domain.base.BaseDateTimeEntity;
import hello.querydslexample.domain.product.variant.Variant;
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
@Table(name = "products")
@Entity
public class Product extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String handle;

    private String title;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<Variant> variants = new ArrayList<>();
}
