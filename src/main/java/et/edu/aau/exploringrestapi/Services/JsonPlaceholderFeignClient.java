package et.edu.aau.exploringrestapi.Services;

import et.edu.aau.exploringrestapi.Dtos.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderFeignClient {

    @GetMapping("/posts/{id}")
    Post getPost(@PathVariable Long id);

}
