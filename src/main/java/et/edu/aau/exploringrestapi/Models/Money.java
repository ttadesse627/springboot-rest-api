package et.edu.aau.exploringrestapi.Models;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Money {
    BigDecimal amount;
    String currency;
}
