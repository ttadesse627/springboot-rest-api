package et.edu.aau.exploringrestapi.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    private String name;
    private final int age = 30;
    private String email;
}
