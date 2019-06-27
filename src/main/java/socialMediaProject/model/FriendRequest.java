package socialMediaProject.model;

import javax.persistence.*;

@Entity
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="sender_profile_id")
    private Integer senderProfileId;

    @Column(name="receiver_profile_id")
    private Integer receiverProfileId;

    @Enumerated(value = EnumType.STRING)
    private FriendRequestStatus status;


    public FriendRequest(Integer id, Integer senderProfileId, Integer receiverProfileId, FriendRequestStatus status) {
        this.id = id;
        this.senderProfileId = senderProfileId;
        this.receiverProfileId = receiverProfileId;
        this.status = status;
    }

    public FriendRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderProfileId() {
        return senderProfileId;
    }

    public void setSenderProfileId(Integer senderProfileId) {
        this.senderProfileId = senderProfileId;
    }

    public Integer getReceiverProfileId() {
        return receiverProfileId;
    }

    public void setReceiverProfileId(Integer receiverProfileId) {
        this.receiverProfileId = receiverProfileId;
    }

    public FriendRequestStatus getStatus() {
        return status;
    }

    public void setStatus(FriendRequestStatus status) {
        this.status = status;
    }

    public enum FriendRequestStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
