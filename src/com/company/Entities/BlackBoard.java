package com.company.Entities;

import com.company.Helpers.MyRandom;
import com.company.Entities.User.User;

import java.util.ArrayList;

public class BlackBoard
{
    private final int sessionId;
    private ArrayList<User> users;


    public BlackBoard()
    {
        this.sessionId = MyRandom.Range(0, 10000);
        users = new ArrayList<>();
    }


    public int getSessionId()
    {
        return this.sessionId;
    }

    public ArrayList<User> getUsers()
    {
        return this.users;
    }

    public void setUsers(ArrayList<User> users)
    {
        this.users = users;
    }
}
