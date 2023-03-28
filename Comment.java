package socialmedia;

import java.util.HashMap;

public class Comment {

    public static final HashMap<Integer, Comment> commentMap = new HashMap<>();
    public static final HashMap<String, Integer> commentIdMap = new HashMap<>();

    int commentId;
    String handle;
    int parentPostID;
    public String commentMessage;
    int commentPopularity;

    public Comment(int commentId, String handle, int parentPostID, String commentMessage) {
        this.commentId = commentId;
        this.handle = handle;
        this.parentPostID = parentPostID;
        this.commentMessage = commentMessage;
        this.commentPopularity = commentPopularity;
    }

    public Comment createComment(int endorsementId, String handle, int parentPostID, String endorsedMessage) {
        Comment outputComment = new Comment(endorsementId, handle, parentPostID, endorsedMessage);
        return outputComment;
    }

}