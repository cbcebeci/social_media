package socialMediaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialMediaProject.model.Friend;
import socialMediaProject.model.FriendRequest;
import socialMediaProject.model.User;
import socialMediaProject.repository.FriendRequestRepository;
import socialMediaProject.repository.FriendRepository;
import socialMediaProject.util.UserUtil;


@Service
public class FriendRequestService {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private FriendRepository friendRepository;


    public void sendFriendRequest(User user) {
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setReceiverProfileId(user.getUserProfile().getId());

        User senderUser = UserUtil.getLoggedInUser(userService);
        friendRequest.setSenderProfileId(senderUser.getUserProfile().getId());

        friendRequest.setStatus(FriendRequest.FriendRequestStatus.PENDING);
        friendRequestRepository.save(friendRequest);
    }

    public void checkMyFriendRequests (){
        User user = UserUtil.getLoggedInUser(userService);
        friendRequestRepository.findAllByReceiverProfileId(user.getUserProfile().getId());
    }

    public void acceptFriendRequest (FriendRequest friendRequest){
        User user = UserUtil.getLoggedInUser(userService);
        friendRepository.save(new Friend(friendRequest.getSenderProfileId(), user.getUserProfile().getId()));
        friendRequest.setStatus(FriendRequest.FriendRequestStatus.APPROVED);
        friendRequestRepository.save(friendRequest);

    }
}
