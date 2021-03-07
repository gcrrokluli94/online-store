package online.store.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import online.store.model.enumeration.PaymentMethod;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {

    @NotNull
    private double totalPrice;
    private PaymentMethod paymentMethod;
    private Long userId;
}
