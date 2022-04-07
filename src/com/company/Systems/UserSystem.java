package com.company.Systems;

import com.company.Entities.User.User;
import com.company.Helpers.Console;

public final class UserSystem
{
    private UserSystem(){}


    public static void updateUserData(User user)
    {
        System.out.println("1-Change Username");
        System.out.println("2-Change Password");
        System.out.print("Pick a number >");

        var choice = Console.nextInt();

        Console.printLine();

        if (choice == 1)
        {
            var newUsername = Console.pickUsername();

            user.setUserName(newUsername);

            Console.printSuccess("User's Username has Updated to " + newUsername);

            Console.printLine();
            return;
        }

        if (choice == 2)
        {
            var newPassword = Console.pickPassword();

            user.setPassword(newPassword);

            Console.printSuccess("User's password has Updated to " + newPassword);

            Console.printLine();
            return;
        }

        Console.printError("Invalid Option!");

        Console.printLine();
    }

    public static void ChangeUserName(User user, String newUserName)
    {
        user.setUserName(newUserName);
    }

    public static void ChangePassword(User user, String newPassword)
    {
        user.setPassword(newPassword);
    }
}
