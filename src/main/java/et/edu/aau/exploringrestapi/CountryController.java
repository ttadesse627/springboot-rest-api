package et.edu.aau.exploringrestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    @GetMapping("ethiopia")
    public Country ethiopia() {
        return Country.of("Ethiopia", 130);
    }
}
