package socialMediaProject.model;

import javax.persistence.*;

@Entity(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="sender_profile_id")
    private Integer senderProfileId;

    @Column(name="receiver_profile_id")
    private Integer receiverProfileId;

    public Friend() {
    }

    public Friend(Integer senderProfileId, Integer receiverProfileId) {
        this.senderProfileId = senderProfileId;
        this.receiverProfileId = receiverProfileId;
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
}
