package com.company.Systems;

import com.company.Helpers.Console;
import com.company.Entities.User.User;
import com.company.Entities.BlackBoard;

public final class BlackBoardSystem
{
    private BlackBoardSystem(){}


    public static void run(BlackBoard service)
    {
        while (true)
        {
            var pickedUser = Console.pickCommand(service);

            if (pickedUser != null)
            {
                while (true)
                {
                    UserSystem.updateUserData(pickedUser);

                    System.out.print("Type (OK) to return to main commands >");

                    var entry = Console.nextString();

                    if (entry.equals("OK")) break;
                }

                continue;
            }

            System.out.print("Type (q/Q) to shutdown the service >");
            var choice = Console.nextString();

            Console.printLine();

            if (choice.equalsIgnoreCase("q"))
            {
                System.out.println("Shutting down the service...");
                System.out.println("Service has shut down");
                break;
            }
        }
    }

    public static void addUser(BlackBoard service, User user)
    {
        var oldDataBase = service.getUsers();

        oldDataBase.add(user);

        service.setUsers(oldDataBase);
    }

    public static void removeUser(BlackBoard service, User user)
    {
        var oldDataBase = service.getUsers();

        oldDataBase.remove(user);

        service.setUsers(oldDataBase);
    }

    public static User findUser(BlackBoard service, int id)
    {
        for (var user : service.getUsers())
        {
            if (user.id == id) return user;
        }

        Console.printError("User could not found!");
        return null;
    }

    public static User findUser(BlackBoard service, String username)
    {
        for (var user : service.getUsers())
        {
            if (user.getUserName().equals(username)) return user;
        }

        Console.printError("User could not found!");
        return null;
    }

    public static User findUserByIndex(BlackBoard service, int index)
    {
        var users = service.getUsers();

        if (index >= users.size() || index < 0)
        {
            Console.printError("User could not found!");
            return null;
        }

        return users.get(index);
    }
}
