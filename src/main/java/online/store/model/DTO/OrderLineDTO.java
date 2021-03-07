package online.store.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderLineDTO {

    @NotNull
    private Integer quantity;
    private Double totalPrice;
    private Long productId;
    private Long orderId;
    private Long cardId;

}
