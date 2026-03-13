package et.edu.aau.exploringrestapi.Models;

import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@ToString
public class Order {
    private final Long id;
    private final BigDecimal amount;
    private String status = "PENDING";
}
