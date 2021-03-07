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

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {

    @NotNull
    private String phone;
    private String shippingAddress;
    private String clientAddress;
    private String city;
    private String country;
    private String zipCode;


}
