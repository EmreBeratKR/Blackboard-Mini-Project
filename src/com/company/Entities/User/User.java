package com.company.Entities.User;

import com.company.Helpers.Date;
import com.company.Helpers.MyRandom;
import com.company.Enums.Gender;
import com.company.Enums.UserType;

public abstract class User
{
    public final int id;
    public final Date joinDate;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;


    public User(String userName, String password)
    {
        this.id = MyRandom.Range(0, 100000);
        this.userName = userName;
        this.password = password;
        this.firstName = null;
        this.lastName = null;
        this.age = -1;
        this.gender = null;
        this.joinDate = null;
    }

    public User(String userName, String password, String firstName, String lastName, int age, Gender gender, Date joinDate)
    {
        this.id = MyRandom.Range(0, 100000);
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.joinDate = joinDate;
    }

    public abstract UserType getType();

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Gender getGender()
    {
        return this.gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "[" + this.id + "] " + this.userName + " as " + this.getType();
    }
}
