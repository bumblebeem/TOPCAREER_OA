/**
 * Created by mfx on 23/04/2017.
 */
import java.util.*;
import java.io.*;
import java.net.*;
import com.google.gson.*;

public class Solution {
    private final static String url = "http://fg-69c8cbcd.herokuapp.com/user/";

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int userId = scanner.nextInt();
            List<Integer> friendsList = getFriendsListFromUserId(userId);

            // get friends-of-friends of this user, store the relationship in a map
            Map<Integer, List<Integer>> friendsOfFriendsMap = new HashMap<Integer, List<Integer>>();
            for(Integer friendId : friendsList) {
                if(!friendsOfFriendsMap.containsKey(friendId)){
                    List<Integer> temp = getFriendsListFromUserId(friendId);
                    friendsOfFriendsMap.put(friendId, temp);
                }
            }

            // Output the result
            System.out.println("Current requested user ID is " + userId);
            System.out.println("***********************");
            System.out.print("This user's friends' IDs are ");
            for(Integer id : friendsList){
                System.out.print(id + " ");
            }
            System.out.println("");
            System.out.println("***********************");
            System.out.println("This user's friends-of-friends are ");
            for(Map.Entry<Integer, List<Integer>> entry : friendsOfFriendsMap.entrySet()){
                System.out.print(entry.getKey() +  "'s friends are ");
                for(Integer id : entry.getValue()){
                    System.out.print(id + " ");
                }
                System.out.println("");
            }
        }
    }

    private static List<Integer> getFriendsListFromUserId(int id) throws Exception{
        String requestUrl = url + id;
        String jsonString = readUrl(requestUrl);
        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);
        return user.getFriends();
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}
