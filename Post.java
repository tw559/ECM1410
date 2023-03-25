package socialmedia;
import java.util.*;

public class Post{

    public static final HashMap<Integer, Post> post_map = new HashMap<>();
    public static final HashMap<String, Integer> post_id_map = new HashMap<>();
    private static int post_id;
    private static String handle;
    private static String post_message;
    private static int endorsment_no;
    private static int comment_no;
    private static int post_popularity;

    public Post(String handle, int post_id, String post_message) {
        this.post_id = post_id;
        this.handle = handle;
        this.post_message = post_message;
        this.endorsment_no = endorsment_no;
        this.comment_no = comment_no;
        this.post_popularity = post_popularity;
        
    }
    public static int getPost_id() {return post_id;}
    public static String getHandle() {return handle;}
    public static String getPost_Message() {return post_message;}
    public static int getPost_popularity() {return post_popularity;}
    public static int getEndorsment_no() {return endorsment_no;}
    public static int getComment_no() {return comment_no;}


    public String toString() {
        return (" ID: " + getPost_id() +
        ".\n Account: " + getHandle() + 
        ".\n No. endorsements: " + getEndorsment_no() +
        " | No. comments: " + getComment_no() +
        ".\n Post Message: " + getPost_Message());
    }
    public static Post createPost(String handle, String post_message) {
        Post new_post
            = new Post(handle, 1, post_message) ;
        return new_post;
    }
    
    public static void main(String[] args) {
		Post output_post = new Post("handle", 60, "message") ;
        System.out.println(output_post);
        post_map.put(50, (output_post));
        post_id_map.put(handle, 50);
     
    }
}
