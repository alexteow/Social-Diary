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
/**
 * UserHandler
 * This class include menus, write and read diary method. So the user can
 * write,read their diary,store it in a json file and read from a json file.
 */


public class UserHandler {

    static ObjectMapper mapper = new ObjectMapper();
    static Path diaryBasePath = Paths.get("src/main/resources/"); // Json file
    static Scanner input = new Scanner(System.in);

    /**
     * logInMenu is the main menu. Here the user need to create a user before log in.
     * @param userChoice the user is choosing in the main menu
     */

    public static int logInMenu(int userChoice) {
        System.out.println("Welcome to the social diary!");
        System.out.println("You are logged in as: No user.\n");
        System.out.println("How do you want to log in?");
        System.out.println("[1] Select a social diary user");
        System.out.println("[2] Create a social diary user");
        System.out.println("[3] Quit\n");
        return input.nextInt();
    }
    /**
     * logInWithUserMenu
     * After the user have create and select a user then the user can read or create a diary.
     *
     * @param user username user have selected
     */

    public static void logInWithUserMenu(User user) throws IOException {

        Path userDiaryPath = Paths.get(diaryBasePath + "/" + user.getUsername() + ".json");
        int logInWithUserMenuUserChoice = 0;

        do {

            System.out.print("Hi!" + " Your are logged in as: " + user.getUsername() + "\n"); // See which user have logged in.
            System.out.println("[1] Read your own social diary post");
            System.out.println("[2] Write new social diary post");
            System.out.println("[3] Log in as another user");
            System.out.println("[4] Quit social diary");
            logInWithUserMenuUserChoice = input.nextInt();
            input.nextLine(); // So we can use input.nextLine to take and store whole sentence from user


            switch (logInWithUserMenuUserChoice) {

                case 1:

                    System.out.println("Here are all diaries you have written ");
                    System.out.println("By user: " + user.getUsername());
                    readDiary(userDiaryPath); // Printing out all the diary the user have written with readDiary method.
                    System.out.println("Press Q to go back to the user menu again");
                    String choices = input.next();
                    if (choices.equalsIgnoreCase("Q")) {
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Now you are going to write your post to your diary");
                    writeDiary(userDiaryPath, user);
                    break;

                case 3:
                    logInWithUserMenuUserChoice = 4; // Go out from while loop and back to main menu
                    break;

                case 4:
                    System.out.println("Goodbye and welcome back");
                    System.exit(0);

                default:
                    System.out.println("Please choose between 1-3");
                    System.out.print("\n");
                    break;

            }

        } while (logInWithUserMenuUserChoice != 4); // The while loop will continue if the user have not select 4

    }
    /**
     * writeDiary
     * This method let the user write a diary. User can decide title and write a post.
     * Method will take date automatic. Store title,post and date in diaries
     * We will use writeValue method to transform object to JSON.
     */


    public static void writeDiary(Path userDiaryPath, User user) throws IOException {

        if (userDiaryPath.toFile().exists()) {
            List<Diary> userDiaries = List.of(mapper.readValue(userDiaryPath.toFile(), Diary[].class));
            user.setDiaries(userDiaries);
        }

        Diary diary = new Diary();

        System.out.println("Write a title for your diary");
        String title = input.nextLine();
        diary.setTitle(title); // set title to diary

        System.out.println("Write a post for your diary");
        String post = input.nextLine();
        diary.setPost(post);

        DateFormat dateDiary = new SimpleDateFormat("yyyy-MM-dd");
        Date diaryDate = new Date();
        diary.setDate(dateDiary.format(diaryDate));

        List<Diary> diaries = new ArrayList<>(user.getDiaries());
        diaries.add(diary); // add title,post and date to diaries
        user.setDiaries(diaries);

        mapper.writeValue(userDiaryPath.toFile(), diaries);
    }
    /**
     * readDiary
     * This method let the user read their diary.
     * Will print out title and post that the user have written.
     * We will use readValue method to transform JSON to object.
     */

    public static void readDiary(Path userDiaryPath) throws IOException {
        Diary[] allDiaries = mapper.readValue(userDiaryPath.toFile(), Diary[].class);

        for (Diary read : allDiaries) {
            System.out.println("Title: " + read.getTitle());
            System.out.println("Date: " + read.getDate());
            System.out.println("Post: " + read.getPost());

        }

    }

}
