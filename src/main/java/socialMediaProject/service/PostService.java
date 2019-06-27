package socialMediaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialMediaProject.model.Image;
import socialMediaProject.model.Post;
import socialMediaProject.model.User;
import socialMediaProject.repository.PostRepository;
import socialMediaProject.util.UserUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;

    public void sendPost(Post post, List<String> imageUrls){
        User user = UserUtil.getLoggedInUser(userService);
        List<Image> images = new ArrayList<>();

        for (String imageUrl :  imageUrls) {
            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setPost(post);
            images.add(image);
        }

        post.setProfileId(user.getUserProfile().getId());
        post.setImages(images);
        postRepository.save(post);

    }

    public List<Post> getUserPosts(){
        User user = UserUtil.getLoggedInUser(userService);
        return postRepository.findPostByProfileId(user.getUserProfile().getId());
    }
}
