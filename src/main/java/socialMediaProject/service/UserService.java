package socialMediaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import socialMediaProject.model.User;
import socialMediaProject.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), Arrays.asList(grantedAuthority));
    }

    public User findUserByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }


    public List<User> findUsersByName(String firstName, String lastName) {

        return userRepository.findUserByUserProfileFirstNameOrUserProfileLastName(firstName, lastName);

    }

    public void registerUser(User user) {
        if (user != null) {
            if(user.getUserProfile() != null) {
                user.getUserProfile().setEmail(user.getUserName());
                user.getUserProfile().setUser(user);
            }
            user.setRole("USER");
            userRepository.save(user);
        }
    }

    public String checkIfUserExists (String userName){
        String message = null;
//        boolean existance = userRepository.findByUserName().contains(userName);
//        if(existance){
//
//           message =  "This email is taken";
//        }

        return message;
    }


}
