package dar.backend.postcoreapi.controller;

import dar.backend.postcoreapi.model.PostModel;
import dar.backend.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")

public class PostController {
    @Autowired
    Environment environment;

    @Autowired
    private PostService postService;

    @GetMapping("/check")
    public String check(){
        return "post-core-api is working " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody PostModel postModel) {
        postService.createPost(postModel);
        return new ResponseEntity<>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllEmployees() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getEmployeeById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable String postId,
                                                     @Valid @RequestBody PostModel postModel) {
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
