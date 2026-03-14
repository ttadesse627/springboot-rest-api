package et.edu.aau.exploringrestapi.Models;

import lombok.SneakyThrows;
import java.io.IOException;

public class FileHandler {

    @SneakyThrows
    public void readFile(){
        throw new IOException("boom!");
    }
}
