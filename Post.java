package socialmedia;
import java.util.*;

public class Post{

    public static final HashMap<Integer, Post> post_map = new HashMap<>();
    public static final HashMap<String, Integer> post_id_map = new HashMap<>();
    int post_id;
    String handle;
    String post_message;
    int endorsement_no;
    int comment_no;
    int post_popularity;

    public Post(String handle, int post_id, String post_message) {
        this.post_id = post_id;
        this.handle = handle;
        this.post_message = post_message;
        this.endorsement_no = endorsement_no;
        this.comment_no = comment_no;
        this.post_popularity = post_popularity;

    }
    public int getPost_id() {return post_id;}
    public String getHandle() {return handle;}
    public String getPost_Message() {return post_message;}
    public int getPost_popularity() {return post_popularity;}
    public int getEndorsement_no() {return endorsement_no;}
    public int getComment_no() {return comment_no;}


    public String toString() {
        return (" ID: " + getPost_id() +
                ".\n Account: " + getHandle() +
                ".\n No. endorsements: " + getEndorsement_no() +
                " | No. comments: " + getComment_no() +
                ".\n Post Message: " + getPost_Message());
    }
    public static Post createPost(String handle, String post_message) {
        Post new_post
                = new Post(handle, 1, post_message) ;
        return new_post;
    }

    public static void main(String[] args) {
        Post output1 = new Post("handle", 1, "message") ;
        ;

    }
}
