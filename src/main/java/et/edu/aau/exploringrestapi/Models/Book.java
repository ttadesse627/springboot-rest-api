package et.edu.aau.exploringrestapi.Models;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @EqualsAndHashCode.Include private String isbn;
    private String title;
}
