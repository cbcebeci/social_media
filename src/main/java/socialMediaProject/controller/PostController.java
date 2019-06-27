package socialMediaProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import socialMediaProject.model.Post;
import socialMediaProject.service.ImageService;
import socialMediaProject.service.PostService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ImageService imageService;


    @PostMapping(path="/post")
    public ModelAndView sendPost(@ModelAttribute Post post, @RequestParam("pictures") MultipartFile[] multipartFiles){
        ModelAndView modelAndView = new ModelAndView();
        List<String> imageUrls =  new ArrayList<>();
        if(multipartFiles != null && multipartFiles.length != 0) {
            imageUrls = imageService.saveImages(multipartFiles);
        }
        postService.sendPost(post, imageUrls);
        modelAndView.setViewName("home");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("posts", postService.getUserPosts());
        return modelAndView;
    }

    @RequestMapping(value = "image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File("/Users/canberkcebeci/Desktop/project-images/" + imageName + ".jpg");

        return Files.readAllBytes(serverFile.toPath());
    }


}

