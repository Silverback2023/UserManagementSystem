import java.util.List;
import java.util.Scanner;

import controller.UserController;
import dao.UserDAO;
import dto.User;

public class App {
    public static void main(String[] args) throws Exception {
        showUserMenu();
    }

    public static void showUserMenu() {
        Scanner sc = new Scanner(System.in);
        UserController userController = new UserController();

        String userSelected = "";

        do {
            System.out.println("**************************************");
            System.out.println("1: Register a user");
            System.out.println("2: Get All Users");
            System.out.println("3: Delete a User");
            System.out.println("4: Update a user");
            System.out.println("5: EXIT");
            System.out.println("6: Get User By ID");
            System.out.println("**************************************");

            userSelected = sc.nextLine();

            switch (userSelected) {
                case "1":
                    System.out.println("Enter User Name: ");
                    String userName = sc.nextLine();

                    System.out.println("Enter User Email: ");
                    String userEmail = sc.nextLine();

                    System.out.println("Enter User Password: ");
                    String userPassword = sc.nextLine();

                    System.out.println("Enter User age: ");
                    int userAge = sc.nextInt();

                    User user = new User(userName, userEmail, userPassword, userAge);
                    userController.insert(user);
                    break;

                case "2": 
                    System.out.println("---------------------");
                    displayUserList(userController.getUserList());
                    System.out.println("---------------------");
                    break;

                case "3":
                    System.out.println("---------------------");
                    displayUserList(userController.getUserList());
                    System.out.println("---------------------");
                
                    System.out.println("Enter User Id you want to delete : ");
                    int id = sc.nextInt();
                    userController.delete(id);

                    System.out.println("------AFTER DELETING---------");
                    displayUserList(userController.getUserList());
                    System.out.println("---------------------");
                    break;

                case "4":
                    System.out.println("---------------------");
                    displayUserList(userController.getUserList());
                    System.out.println("---------------------");
                
                    System.out.println("Enter User Id you want to update : ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Enter User Name: ");
                    String updatedName = sc.nextLine();

                    System.out.println("Enter User Email: ");
                    String updatedEmail = sc.nextLine();

                    System.out.println("Enter User Password: ");
                    String updatedPassword = sc.nextLine();

                    System.out.println("Enter User age: ");
                    int updatedAge = sc.nextInt();

                    User updatedUser = new User(updatedName, updatedEmail, updatedPassword, updatedAge);
                    updatedUser.setId(updateId);
                    userController.update(updatedUser);

                    System.out.println("------AFTER UPDATING---------");
                    displayUserList(userController.getUserList());
                    System.out.println("---------------------");
                    break;

                case "5":
                    System.out.println("Exiting the application...");
                    break;

                case "6":
                    System.out.println("Enter User Id: ");
                    int userId = sc.nextInt();
                    User userById = userController.getUserById(userId);
                    if (userById != null) {
                        System.out.println("---------------------");
                        userById.getUserInfo();
                        System.out.println("---------------------");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid option selected. Please try again.");
                    break;
            }
        } while (!userSelected.equals("5")); 
        sc.close();
    }


    public static void displayUserList(List<User> users) {
        for (User user: users) {
            user.getUserInfo();
       

    }
 }
}