package com.company;

import com.company.Entities.BlackBoard;
import com.company.Systems.BlackBoardSystem;

public class Main
{
    public static void main(String[] args)
    {
        var service = new BlackBoard();

        BlackBoardSystem.run(service);
    }
}
