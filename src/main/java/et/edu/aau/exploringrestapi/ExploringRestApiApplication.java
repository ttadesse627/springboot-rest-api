package et.edu.aau.exploringrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExploringRestApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExploringRestApiApplication.class, args);
    }

}
