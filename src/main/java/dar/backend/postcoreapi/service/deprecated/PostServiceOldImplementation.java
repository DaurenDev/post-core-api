package dar.backend.postcoreapi.service.deprecated;

import dar.backend.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PostServiceOldImplementation implements PostServiceOld {
    private static final HashMap<String, PostModel> modelMap  = new HashMap<>();

    static {
        PostModel postModel = new PostModel("Post1", "Client1",
                                            "Recipient1", "PostName", "On the way");
        PostModel postModel3 = new PostModel("Post1", "Client1",
                "Recipient1", "PostName", "On the way");
        PostModel postModel2 = new PostModel("Post2", "Client2",
                "Recipient1", "PostName2", "Here");
    }
    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId("Another Post");
        modelMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(modelMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return modelMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        modelMap.put(postId, postModel);
    }

    @Override
    public void deletePostById(String postId) {
        modelMap.remove(postId);
    }
}
