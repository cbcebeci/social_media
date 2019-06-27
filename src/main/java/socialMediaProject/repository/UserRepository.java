package socialMediaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialMediaProject.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserName(String username);

    List<User> findUserByUserProfileFirstNameOrUserProfileLastName(String firstName, String lastName);
}
