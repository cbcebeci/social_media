package socialMediaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMediaProject.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
