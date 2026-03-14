package et.edu.aau.exploringrestapi.Models;

import et.edu.aau.exploringrestapi.Dtos.UserDto;
import lombok.NonNull;

public class Service {
    public void save(@NonNull UserDto user){} //Not nullable objects (throws null pointer exception)
}
