package SocialDiary;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String selection="";
        int userChoice = 0;

        do {
            try {
                userChoice = UserHandler.logInMenu(userChoice);
                switch (userChoice) {
                    case 1:
                        selection = printUsersAndSelect();
                        if (selection.equalsIgnoreCase("Q")) {
                            break;
                        } else if (selection.equals("0")) {
                            System.out.println("Try again");
                            break;
                        } else {
                            selection = UserHandler.userNames.get(Integer.valueOf(selection) - 1);
                        }
                        UserHandler.logInWithUserMenu(selection);
                        input.next();
                        break;

                    case 2:
                        /* Here can the user create a username.
                         */
                        System.out.println("Please select a user name");
                        System.out.print("Press Q to main menu");
                        String userNameInput = input.next();
                        if (userNameInput.equalsIgnoreCase("Q")) {
                            break;
                        }
                        else if (!userNameInput.equals("Q")){
                            String userNameWithUpperCase = userNameInput.substring(0, 1).toUpperCase()
                                    + userNameInput.substring(1);
                            UserHandler.userNames.add(userNameWithUpperCase);
                            break;
                        }

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
        boolean checkUserNamesIsEmpty=UserHandler.userNames.isEmpty();
        if(checkUserNamesIsEmpty==true){
            System.out.println("No user available. You have to create a user first");
            System.out.println("Press 2 to create a user in main menu\n");
        }
        System.out.println("Please select a user or press Q to main menu");
        for (int i = 0; i < UserHandler.userNames.size(); i++) {
            System.out.print("\n");
            System.out.println((1 + i) + "." + " " + UserHandler.userNames.get(i));

        }
        System.out.print("\n");
        return input.next();
    }
}