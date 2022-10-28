package SocialDiary;

import java.util.ArrayList;
import java.util.List;

/**
 *This class is for the User. Every user have a username and a diary.
 Include get and set method,constructor and list.
 */
public class User {
    private String username;
    private List<Diary> diaries = new ArrayList<>();


    /**
     * @param username constructor for the username
     */
    public User(String username){
        this.username=username;
    }

    public User(){

    }

    /** Gets the username
     * @return string representing username
     * Every user will set a diary and return a diary from the diaries list.
     */

    public String getUsername() {
        return username;
    } // This will return the username of the User

    public void setUsername(String username) { // User will set a username.
        this.username = username;
    }
    public List<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Diary> diaries) {
        this.diaries = diaries;
    }
}
