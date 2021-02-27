package online.store.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_Id")
    private Long id;

    private String name;
    private String description;
    private int masterCategory;

    @OneToMany(mappedBy = "productCategories")
    private Set<Product> products;
}
