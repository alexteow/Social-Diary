package SocialDiary;

/**
 * This class is for the Diary.
 * Include get and set method and constructor.
 */

public class Diary {
    private String title;
    private String date;
    private String post;

    /**
     * @param title constructor for the title
     * @param date  constructor for the date
     * @param post  constructor for the date
     */
    public Diary(String title, String date, String post) {
        this.title = title;
        this.date = date;
        this.post = post;
    }

    public Diary() {

    }

    /**
     * Gets the Diary title,date and post
     *
     * @return String representing diary title,date and post
     */


    public String getTitle() { // get
        return title;
    }// This will return the title of the Diary

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }// User will set the post.

    public String toString() {
        return
        "Title is: " + this.getTitle() +
        " Date: " + this.getDate() +
        " Post : " + this.getPost();
        }
}




