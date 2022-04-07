package com.company.Entities.User;

import com.company.Helpers.Date;
import com.company.Enums.Field;
import com.company.Enums.Gender;
import com.company.Enums.UserType;

public class Student extends User
{
    private Field field;
    private double gpa;


    public Student(String userName, String password)
    {
        super(userName, password);
    }

    public Student(String userName, String password, String firstName, String lastName, int age, Gender gender, Date joinDate)
    {
        super(userName, password, firstName, lastName, age, gender, joinDate);
    }

    @Override
    public UserType getType()
    {
        return UserType.STUDENT;
    }

    public Field getField()
    {
        return this.field;
    }

    public void setField(Field field)
    {
        this.field = field;
    }

    public double getGpa()
    {
        return this.gpa;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

}
