package com.company.Helpers;

import com.company.Enums.Month;

public class Date
{
    public final int day;
    public final Month month;
    public final int year;


    public Date(int day, Month month, int year)
    {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    public Date(Date date)
    {
        this.day = date.day;
        this.month = date.month;
        this.year = date.year;
    }


    public String asDigital()
    {
        return Stringf.toDigital(day, 2) + "/" + Stringf.toDigital(month.ordinal(), 2) + "/" + year;
    }

    public String asDigital(String separator)
    {
        return Stringf.toDigital(day, 2) + separator + Stringf.toDigital(month.ordinal(), 2) + separator + year;
    }

    @Override
    public String toString()
    {
        return Stringf.toOrdinal(day) + " of " + month + " " + year;
    }
}
