package et.edu.aau.exploringrestapi.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @NonNull private final Long id;
    private String name;
}
