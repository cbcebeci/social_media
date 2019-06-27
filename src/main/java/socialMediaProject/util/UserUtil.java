package socialMediaProject.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import socialMediaProject.model.User;
import socialMediaProject.service.UserService;

@Component
public class UserUtil {

    public static User getLoggedInUser(UserService userService) {
        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findUserByUserName(springUser.getUsername());
    }
}
