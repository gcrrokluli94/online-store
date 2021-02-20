package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import online.store.model.enumeration.ProductType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;

    @ManyToOne
    @JsonIgnoreProperties(value="products", allowSetters = true)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategories;

    @OneToMany(mappedBy ="product")
    private Set<OrderLine> orderLine;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
