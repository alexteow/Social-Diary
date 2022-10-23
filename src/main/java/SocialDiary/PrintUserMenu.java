package SocialDiary;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrintUserMenu {
    static List<String> userNames = new ArrayList<String>();
    static List<Diary> listOfDiary = new ArrayList<Diary>();
    static List<Diary> allDiaryPost = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();
    static Path diaryPath = Paths.get("src/main/resources/diary.json");
    static Diary writePost = new Diary();
    static DateFormat dateDiary = new SimpleDateFormat("yyyy-MM-dd");
    static Date diaryDate = new Date();
    static Scanner input = new Scanner(System.in);

    public static int logInMenu(int userChoice) {
        System.out.println("Welcome to the social diary!");
        System.out.println("You are logged in as: No user.");
        System.out.println("How do you want to log in?\n");
        System.out.println("[1] Select a social diary user");
        System.out.println("[2] Create a social diary user");
        System.out.println("[3] Quit");
        return input.nextInt();
    }

    public static void logInWithUserMenu(String select) throws IOException {

        /**
         If the user select a username then they are going to this menu.
         diary- List that store all diary both from non user and user.
         userDiary- List that store diary only from user
         */

        String userTitle = " ";
        String userPost = " ";
        String selectOtherUserDiaryPost;
        String selectOwnUserDiaryPost;
        int logInWithUserMenuUserChoice = 0;
        Scanner input = new Scanner(System.in);

        do {

            System.out.print("Hi!" + " Your are logged in as: " + select + "\n"); // See which user have logged in.
            System.out.println("[1] Read your own social diary post");
            System.out.println("[2] Write new social diary post");
            System.out.println("[3] Log out and go to main menu");
            System.out.println("[4] Quit social diary");
            logInWithUserMenuUserChoice = input.nextInt();


            switch (logInWithUserMenuUserChoice) {

                case 1:
                    /*Here the user can see all the diary that the user have written
                     */
                    System.out.println("Here are all diary you have written ");
                    System.out.println("By user: " + select);
                    readDiary();
                    System.out.println("Press Q to go back to the user menu again");
                    String choices = input.next().toUpperCase();
                    if (choices.equals("Q")) {
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Now you are going to write your post to your diary");
                    System.out.println("Press Q if you don't want to write and you will " +
                            "go back to main menu");
                    System.out.println("Press W to write your diary");
                    String choicesWrite = input.next().toUpperCase();
                    if (choicesWrite.equals("Q")) {
                        break;
                    } else if (choicesWrite.equals("W")) {
                        writeDiary();
                        break;
                    }


                case 3:
                    logInMenu(logInWithUserMenuUserChoice);
                    break;

                case 4:
                    System.out.println("Goodbye and welcome back");
                    break;


                default:
                    System.out.println("Please choose between 1-4");
                    System.out.print("\n");
                    break;

            }

        } while (logInWithUserMenuUserChoice != 4);
    }

    public static void writeDiary() throws IOException {

        if (diaryPath.toFile().exists()) {
            allDiaryPost = List.of(mapper.readValue(diaryPath.toFile(), Diary[].class));
            listOfDiary.addAll(allDiaryPost);
        }
        System.out.println("Now its time to write your post");


        System.out.println("Write a title for your diary");

        String title = input.next();
        writePost.setTitle(title);

        System.out.println("Write a post for your diary");

        String post = input.next();
        writePost.setPost(post);

        writePost.setDate(dateDiary.format(diaryDate));

        listOfDiary.add(writePost);

        mapper.writeValue(diaryPath.toFile(), listOfDiary);
    }

    public static void readDiary() throws IOException {
        Diary[] allDiary;
        allDiary = mapper.readValue(diaryPath.toFile(),
                Diary[].class);

        for (Diary read : allDiary) {
            System.out.println("Title: " + read.getTitle());
            System.out.println("Date: " + read.getDate());
            System.out.println("Post: " + read.getPost());

        }

    }

}
