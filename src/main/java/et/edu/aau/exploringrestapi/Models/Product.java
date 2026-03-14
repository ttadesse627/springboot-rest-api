package et.edu.aau.exploringrestapi.Models;

import lombok.ToString;

@ToString(includeFieldNames = true, onlyExplicitlyIncluded = true)
public class Product {
    @ToString.Include private String sku;
    private double price;
}
