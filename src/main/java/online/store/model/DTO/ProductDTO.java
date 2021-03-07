package online.store.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import online.store.model.enumeration.ProductStatus;
import online.store.model.enumeration.ProductType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
    private Long categoryId;
    private Long authorId;
    private String productName;
    private String description;
    private Double price;
    private ProductStatus productStatus;
    private ProductType productType;
}
