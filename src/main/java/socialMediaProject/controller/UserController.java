package socialMediaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import socialMediaProject.model.Post;
import org.springframework.web.servlet.ModelAndView;
import socialMediaProject.model.User;
import socialMediaProject.service.PostService;
import socialMediaProject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping(path = "/signup")
    public String showRegistration (Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("posts", postService.getUserPosts());
        return "home";
    }

    @PostMapping(path = "/signup")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "signupsuccess";
    }


    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }



    @GetMapping(path="/search")
    public String showSearch(){
        return "search";
    }


    @PostMapping(path="/search")
    public ModelAndView search (@ModelAttribute("searchName") String searchName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("users", userService.findUsersByName(searchName, searchName));
        return modelAndView;
    }

}
