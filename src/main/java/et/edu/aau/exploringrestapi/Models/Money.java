package et.edu.aau.exploringrestapi.Models;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Money {
    private BigDecimal amount;
    private String currency;
}
