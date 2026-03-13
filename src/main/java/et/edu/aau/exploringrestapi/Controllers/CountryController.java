package et.edu.aau.exploringrestapi.Controllers;

import et.edu.aau.exploringrestapi.Models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    @GetMapping("france")
    public Country frnace() {
        Country country = Country.of("France", 67);
        return country;
    }
    @GetMapping("ethiopia")
    public ResponseEntity<Country> ethiopia() {
        Country country = Country.of("Ethiopia", 130);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Continent", "Africa")
                .header("Capital", "Finfinne")
                .header("Favorite-Food", "Doro watt")
                .body(country);
    }

    @GetMapping()
    public ResponseEntity<List<Country>> getCountries() {
        Country country = Country.of("Ethiopia", 130);
        Country country1 = Country.of("Kenya", 55);
        Country country2 = Country.of("Tanzania", 65);
        Country country3 = Country.of("Uganda", 48);
        Country country4 = Country.of("Rwanda", 13);
        Country country5 = Country.of("South Africa", 60);
        Country country6 = Country.of("Nigeria", 220);
        Country country7 = Country.of("Egypt", 110);
        Country country8 = Country.of("Morocco", 38);
        Country country9 = Country.of("Ghana", 33);
        Country country10 = Country.of("Mozambique", 32);

        List<Country> countries = List.of(country1,  country2, country3, country4, country5, country6, country7, country8, country9, country10);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Continent", "Africa")
                .body(countries);

    }
}
