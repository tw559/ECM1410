package socialmedia;
import java.util.*;

public class Post{
    public static final HashMap<Integer, Post> post_map = new HashMap<>();
    private static int post_id;
    private static String handle;
    private static String post_message;
    //private static int post_popularity;

    public Post(String handle, int post_id, String post_message) {
        this.post_id = post_id;
        this.handle = handle;
        this.post_message = post_message;
        //this.post_popularity = post_popularity;
    }
    public static int getPost_id() {return post_id;}
    public static String getHandle() {return handle;}
    public static String getPost_Message() {return post_message;}
    //public static int getPost_popularity() {return post_popularity;}


    public String toString() {
        return ("ID: " + getPost_id()
                + ".\n Account: " + getHandle()
                + ".\n Post Message: " + getPost_Message());
    }
    public static Post createPost(String handle, String post_message) {
        Post new_post
            = new Post(handle, 1, post_message) ;
        return new_post;
    }
    public static void main(String[] args) {
        Post post;
        post = createPost("user", "Hello there");
        post_map.put(1, (post));
        System.out.println(post_map);
    }
}
