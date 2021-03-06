package online.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Long id;

    private String name;
    private String description;
    private int masterCategory;

    @OneToMany(mappedBy = "productCategory" , fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name="parentId")
    private ProductCategory parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductCategory> childCategories;
}
