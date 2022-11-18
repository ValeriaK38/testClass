package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //lists of names:
        List<String> nameList1 = Arrays.asList("John", "Benji", "Alex", "Henry", "Nick", "Mike", "Alon", "Ron");
        List<String> nameList2 = Arrays.asList("Dana", "Roni", "Bar", "Diana", "Hana", "Lisa", "Beti");

        Team team1 = new Team(nameList1, 1, 3, 3, 4);
        System.out.println("--- TEAM 1  ---- " + team1.toString());
//            team1.writeToFile("team1"); //

        Team team2 = new Team(nameList2, 1, 3, 3, 4);
        System.out.println("--- TEAM 2  ---- " + team2.toString());
        team2.writeToFile("team2"); //

    }
}