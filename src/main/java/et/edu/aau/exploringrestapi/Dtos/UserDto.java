package et.edu.aau.exploringrestapi.Dtos;

import lombok.Data;

@Data
public class UserDto {
    private final Long id;
    private String name;
    private String email;
}