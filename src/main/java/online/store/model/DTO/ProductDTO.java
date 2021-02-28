package online.store.model.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import online.store.model.Author;
import online.store.model.ProductCategory;
import online.store.model.enumeration.ProductStatus;
import online.store.model.enumeration.ProductType;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    @NotNull
    private String productName;
    private String description;
    private ProductCategory productCategories;
    private BigDecimal price;
    private ProductType productType;
    private String imageUrl;
    private ProductStatus productStatus;
    private Author author;

    }
