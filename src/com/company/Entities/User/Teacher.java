package com.company.Entities.User;

import com.company.Helpers.Date;
import com.company.Enums.Gender;
import com.company.Enums.UserType;

public class Teacher extends User
{
    public Teacher(String userName, String password)
    {
        super(userName, password);
    }

    public Teacher(String userName, String password, String firstName, String lastName, int age, Gender gender, Date joinDate)
    {
        super(userName, password, firstName, lastName, age, gender, joinDate);
    }

    @Override
    public UserType getType()
    {
        return UserType.TEACHER;
    }

}
