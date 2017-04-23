/**
 * Created by mfx on 23/04/2017.
 */
import java.util.*;

public class User {
    private int id;
    private String username;
    private List<Integer> friends;

    User(){}

    User(int id, String username, List<Integer> friends){
        this.id = id;
        this.username = username;
        this.friends = friends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = friends;
    }

}
