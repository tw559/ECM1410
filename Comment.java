package socialmedia;

import java.util.HashMap;

public class Comment {

    public static final HashMap<Integer, Comment> commentMap = new HashMap<>();
    public static final HashMap<String, Integer> commentIdMap = new HashMap<>();

    int commentId;
    String handle;
    int parentPostID;
    public String commentMessage;
    int commentEndorsement;
    int commentComment;

    public Comment(int commentId, String handle, int parentPostID, String commentMessage) {
        this.commentId = commentId;
        this.handle = handle;
        this.parentPostID = parentPostID;
        this.commentMessage = commentMessage;
        this.commentEndorsement = commentEndorsement;
        this.commentComment = commentComment;
    }

    public int getCommentId() {return commentId;}
    public String getHandle() {return handle;}
    public int getParentPostId() {return parentPostID;}
    public String getCommentMessage() {return commentMessage;}
    public int getCommentEndorsement() {return commentEndorsement;}
    public int getCommentComment() {return commentComment;}


    public String toString() {
        return (" ID: " + getCommentId() +
                ".\n Account: " + getHandle() +
                ".\n No. endorsements: " + getCommentEndorsement() +
                " | No. comments: " + getCommentComment() +
                ".\n Post Message: " + getCommentMessage());}

    public Comment createComment(int endorsementId, String handle, int parentPostID, String endorsedMessage) {
        Comment outputComment = new Comment(endorsementId, handle, parentPostID, endorsedMessage);
        return outputComment;
    }

}
