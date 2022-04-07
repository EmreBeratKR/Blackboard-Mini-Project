package com.company.Helpers;

public final class Stringf
{
    private Stringf(){}

    public static String toOrdinal(int number)
    {
        if (number <= 0) return "Error!";

        String result = String.valueOf(number);

        char lastChar = result.charAt(result.length()-1);

        return switch (lastChar)
        {
            case '1' -> result + "st";
            case '2' -> result + "nd";
            case '3' -> result + "rd";
            default -> result + "th";
        };
    }

    public static String toDigital(int number, int digits)
    {
        if (number < 0) return "ERROR!";

        if (digits < 1) return "ERROR!";

        StringBuilder result = new StringBuilder(String.valueOf(number));

        while (result.length() < digits)
        {
            result.insert(0, "0");
        }

        return result.toString();
    }

    public static String multiply(String base, int times)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++)
        {
            result.append(base);
        }

        return result.toString();
    }
}
