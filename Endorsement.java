package socialmedia;

import java.util.HashMap;

public class Endorsement {

    public static final HashMap<Integer, Endorsement> endorsementMap = new HashMap<>();
    public static final HashMap<String, Integer> EndorsementIdMap = new HashMap<>();

    int endorsementId;
    String handle;
    String endorsedHandle;
    String endorsedMessage;

    public Endorsement(int endorsementID, String handle, String endorsedHandle, String endorsedMessage) {
        this.endorsementId = endorsementID;
        this.handle = handle;
        this.endorsedHandle = endorsedHandle;
        this.endorsedMessage = endorsedMessage;
    }

    public String getEndorsedHandle() {return endorsedHandle;}
    public String getEndorsedMessage() {return endorsedMessage;}

    public String toString() {
        return ("EP@" + getEndorsedHandle() + ": " + getEndorsedMessage());
    }

    public Endorsement createEndorsement(int endorsementId, String handle, String endorsedHandle, String endorsedMessage) {
        Endorsement outputEndorsement = new Endorsement(endorsementId, handle, endorsedHandle, endorsedMessage);
        return outputEndorsement;
    }


}
