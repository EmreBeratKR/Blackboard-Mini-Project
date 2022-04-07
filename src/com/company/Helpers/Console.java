package com.company.Helpers;

import com.company.Enums.UserType;
import com.company.Entities.User.*;
import com.company.Entities.BlackBoard;
import com.company.Systems.BlackBoardSystem;

import java.util.Scanner;

public final class Console
{
    private static final Scanner scanner = new Scanner(System.in);


    private Console(){}


    public static void printLine()
    {
        System.out.println("------------------------------------------------------------");
    }

    public static void printError(String msg)
    {
        System.out.println("ERROR: " + msg);
    }

    public static void printSuccess(String msg)
    {
        System.out.println("SUCCESS: " + msg);
    }


    public static String nextString()
    {
        return scanner.nextLine();
    }

    public static int nextInt()
    {
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static User pickCommand(BlackBoard service)
    {
        System.out.println("1-Add User");
        System.out.println("2-Remove User");
        System.out.println("3-Find User by id");
        System.out.println("4-Find User by username");
        System.out.println("5-Select User from database");
        System.out.println("6-Print all the Users from database");

        Console.printLine();

        System.out.print("Pick a command >");

        var command = Console.nextInt();

        Console.printLine();

        switch (command)
        {
            case 1 -> {
                var newUser = Console.createUser();
                BlackBoardSystem.addUser(service, newUser);
                Console.printSuccess("The User " + newUser.getUserName() + " has added!");

                Console.printLine();
            }

            case 2 -> {
                System.out.println("1-Remove User by id");
                System.out.println("2-Remove User by username");
                System.out.print("Pick a number >");

                var choice = Console.nextInt();

                User userToRemove = null;

                if (choice == 1)
                {
                    var id = Console.pickId();
                    userToRemove = BlackBoardSystem.findUser(service, id);
                } else if (choice == 2)
                {
                    var username = Console.pickUsername();
                    userToRemove = BlackBoardSystem.findUser(service, username);
                }
                if (userToRemove == null)
                {
                    Console.printError("Cannot remove the User because the User is not existed!");

                    Console.printLine();

                    return null;
                }

                BlackBoardSystem.removeUser(service, userToRemove);

                Console.printSuccess("The User " + userToRemove.getUserName() + " has removed!");

                Console.printLine();
            }

            case 3 -> {
                var id = Console.pickId();

                var result = BlackBoardSystem.findUser(service, id);

                if (result == null) return null;

                System.out.println("Search result : " + result);

                Console.printLine();

                return result;
            }

            case 4 -> {
                var username = Console.pickUsername();

                var result = BlackBoardSystem.findUser(service, username);

                if (result == null) return null;

                System.out.println("Search result : " + result);

                Console.printLine();

                return result;
            }

            case 5 -> {
                var count = Console.printUsers(service);

                if (count == 0) return null;

                System.out.print("Pick a number >");
                var choice = Console.nextInt();

                var result = BlackBoardSystem.findUserByIndex(service, choice - 1);

                if (result == null)
                {
                    Console.printLine();

                    return null;
                }

                System.out.println("Picked User : " + result);

                Console.printLine();

                return result;
            }

            case 6 -> {
                Console.printUsers(service);
            }

            default -> {
                Console.printError("Invalid Command!");

                Console.printLine();
            }
        }

        return null;
    }

    public static int pickId()
    {
        System.out.print("Enter a id >");
        return Console.nextInt();
    }

    public static String pickUsername()
    {
        System.out.print("Enter a username >");
        return Console.nextString();
    }

    public static String pickPassword()
    {
        System.out.print("Enter a password >");
        return Console.nextString();
    }

    public static UserType pickUserType()
    {
        System.out.println("1-Student");
        System.out.println("2-Teacher");
        System.out.print("Pick a number for the user type >");

        var choice = Console.nextInt();

        var types = UserType.values();

        if (choice > types.length)
        {
            Console.printError("User Type does not exist!");
            return null;
        }

        Console.printLine();

        return UserType.values()[choice - 1];
    }

    public static User createUser()
    {
        var username = Console.pickUsername();

        var password = Console.pickPassword();

        var userType = Console.pickUserType();

        if (userType == null) return null;

        switch (userType)
        {
            case STUDENT -> {
                return new Student(username, password);
            }
            case TEACHER -> {
                return new Teacher(username, password);
            }
        }

        return null;
    }

    public static int printUsers(BlackBoard service)
    {
        var users = service.getUsers();

        if (users.size() == 0)
        {
            Console.printError("The Service has no Users!");

            Console.printLine();

            return 0;
        }

        int counter = 1;
        for (var user : users)
        {
            System.out.printf("(%d)-%s%n", counter, user.toString());
            counter++;
        }

        Console.printLine();

        return counter;
    }
}
