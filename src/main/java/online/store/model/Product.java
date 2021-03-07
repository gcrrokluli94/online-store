package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import online.store.model.enumeration.ProductStatus;
import online.store.model.enumeration.ProductType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String productName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderLine> orderLine;

    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
