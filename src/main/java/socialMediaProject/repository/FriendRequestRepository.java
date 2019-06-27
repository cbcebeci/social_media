package socialMediaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialMediaProject.model.FriendRequest;
import socialMediaProject.model.User;

import java.util.List;


@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {

    List<User> findAllByReceiverProfileId(Integer integer);

}
