package SocialDiary;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String select = "";
        String noUserSelect = "";
        int userChoice = 0;


        do {
            try {
                userChoice = PrintUserMenu.logInMenu(userChoice); // LogInMenu from StartMenuMethod class
                switch (userChoice) {
                    case 1:
                        select = printUsersAndSelect();
                        if (select.equals("Q")) {
                            break;
                        } else if (select.equals("0")) {
                            System.out.println("Try again");
                            break;
                        } else {
                            select = PrintUserMenu.userNames.get(Integer.valueOf(select) - 1);
                        }
                        PrintUserMenu.logInWithUserMenu(select);
                        input.next();
                        break;

                    case 2:
                        /* Here can the user create a username.
                         */
                        System.out.println("Please select a user name");
                        System.out.print("Press Q to main menu");
                        String userNameInput = input.next(); // Create user
                        if (userNameInput.equals("Q")) {
                            break;
                        }

                        String userNameWithUpperCase = userNameInput.substring(0, 1).toUpperCase()
                                + userNameInput.substring(1);
                        PrintUserMenu.userNames.add(userNameWithUpperCase);
                        break;
                    case 3:
                        System.out.println("Goodbye and welcome back");
                        break;

                    default:
                        System.out.println("Please choose between 1-3 in the menu");
                        System.out.print("\n");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Please choose a number between 1-4, try again");
                input.next();
                continue;
            }

        } while (userChoice != 3);

    }
    private static String printUsersAndSelect() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select a user or press Q to main menu");
        for (int i = 0; i < PrintUserMenu.userNames.size(); i++) {
            System.out.print("\n");
            System.out.println((1 + i) + "." + " " + PrintUserMenu.userNames.get(i));
        }
        System.out.print("\n");
        return input.next(); // User select a user from the list
    }
}