package socialMediaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import socialMediaProject.model.FriendRequest;
import socialMediaProject.model.User;
import socialMediaProject.service.FriendRequestService;

@Controller
@RequestMapping("/user")
public class FriendRequestController {

    @Autowired
    private FriendRequestService friendRequestService;


    @PostMapping(path="/sendFriendRequest")
    public ModelAndView sendFriendRequest (@ModelAttribute User user){
        friendRequestService.sendFriendRequest(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("friendRequestSuccess");
        modelAndView.addObject("fullName", user.getUserProfile().getFirstName() + " "
                + user.getUserProfile().getLastName());
        return modelAndView;

    }

    @GetMapping(path = "/myFriendRequest")
    public ModelAndView checkMyFriendRequests (){
        ModelAndView modelAndView = new ModelAndView();
        friendRequestService.checkMyFriendRequests();
        modelAndView.setViewName("myFriendRequest");
        return modelAndView;
    }

    @PostMapping(path = "/acceptFriendRequest")
    public ModelAndView acceptFriendRequest(@ModelAttribute FriendRequest friendRequest){
        ModelAndView modelAndView = new ModelAndView();
        friendRequestService.acceptFriendRequest(friendRequest);
        modelAndView.setViewName("friendRequestAccepted");
        return modelAndView;
    }





}
