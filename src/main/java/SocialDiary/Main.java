package SocialDiary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program is a Diary that you can create a user and write your own diary.
 *
 * @author Alex Teow
 *
 * @since 2022-10-27
 */
public class Main {
    static Scanner input = new Scanner(System.in);
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String selection = "";
        String userChoice ="";
        User user;

        do {
            try {
                userChoice = String.valueOf(UserHandler.logInMenu(userChoice));
                switch (userChoice) {
                    case "1":
                        selection = printUsersAndSelect();
                        if (selection.equalsIgnoreCase("Q")) {
                            break;
                        } else if (selection.equals("0")) {
                            System.out.println("Try again");
                            break;
                        } else {
                            user = users.get(Integer.valueOf(selection) - 1);
                        }
                        UserHandler.logInWithUserMenu(user);
                        break;

                    case "2":

                        System.out.println("Please select a user name");
                        System.out.print("Press Q to main menu\n");
                        String userNameInput = input.next();
                        if (userNameInput.equalsIgnoreCase("Q")) {
                            break;
                        } else if (!userNameInput.equals("Q")) {
                            String userNameWithUpperCase = userNameInput.
                                    substring(0, 1).toUpperCase()
                                    + userNameInput.substring(1);

                            user = new User(userNameWithUpperCase);
                            users.add(user);
                            break;
                        }

                    case "3":
                        System.out.println("Goodbye and welcome back");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please choose between 1-3 in the menu");
                        System.out.print("\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("You entered an invalid number, please try again");
                continue;
            }

        } while (userChoice != "3");

    }
    /**
     * This method printUsersAndSelect is for the user to select a user after the user have creating it.
     If the user have not create a user the program will print out " No user available" and
     guide the user to create one.
     */

    private static String printUsersAndSelect() {

        boolean checkUsersIsEmpty = users.isEmpty(); // Check if the userNames list is empty
        if (checkUsersIsEmpty == true) {
            System.out.println("No user available. You have to create a user first");
            System.out.println("Press Q to go back to main menu and then press on 2 \n");
        }
        System.out.println("Please select a user or press Q to main menu");
        for (int i = 0; i < users.size(); i++) { // printing out userNames list
            System.out.print("\n");
            System.out.println((1 + i) + "." + " " + users.get(i).getUsername());

        }
        System.out.print("\n");
        return input.next();
    }
}
