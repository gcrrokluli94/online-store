package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import online.store.model.enumeration.ProductType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String description;

    @ManyToOne
    @JsonIgnoreProperties(value="products", allowSetters = true)
    private ProductCategory productCategories;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    private ProductType productType;

    private String imageUrl;

    @ManyToOne
    private Author author;
}
