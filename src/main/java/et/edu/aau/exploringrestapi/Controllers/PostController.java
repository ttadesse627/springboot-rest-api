package et.edu.aau.exploringrestapi.Controllers;

import et.edu.aau.exploringrestapi.Dtos.Post;
import et.edu.aau.exploringrestapi.Services.JsonPlaceholderFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final JsonPlaceholderFeignClient jsonPlaceholderFeignClient;

    public PostController(JsonPlaceholderFeignClient jsonPlaceholderFeignClient) {
        this.jsonPlaceholderFeignClient = jsonPlaceholderFeignClient;
    }

    @GetMapping("/posts/{id}")
    public Post getWithFeign(@PathVariable Long id) {
        return jsonPlaceholderFeignClient.getPost(id);
    }
}
