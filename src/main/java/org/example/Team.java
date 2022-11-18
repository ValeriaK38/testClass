package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidParameterException;
import java.util.*;

public class Team {
    private final List<FootballPlayer> footballPlayers = new ArrayList<>();
    private String teamNae;
    private final int NUMBER_OF_PLAYERS = 11;
    private NameGenerator privateNames;
    private String pathOfNames;// - need to do - get path and generate list of names
    //=====================================================================================
    public Team( List inputNameList, int goalKeeper, int defense, int middleFiled, int attack){

        // check team roles from ex 1: 1 GK and at least 2of other positions
        int countPlayers = NUMBER_OF_PLAYERS;
        if ((goalKeeper != 1) ||
                (defense < 2 || middleFiled < 2 || attack < 2) ||
                (countPlayers - (goalKeeper + defense + middleFiled + attack) != 0))
            throw new InvalidParameterException("Position error");

        Stack<Integer> jerseyList = new Stack<>();
        for (int i = 1; i < NUMBER_OF_PLAYERS+1; i++)
            jerseyList.push(i);
        Collections.shuffle(jerseyList); // list of jerseys

        //==============================================================
          privateNames = new NameGenerator(inputNameList);
        // - need to get path and generate list of names instead of list ... :(
        //==============================================================

        for(int i=0; i< goalKeeper; i++)
            createGoalkeepers(jerseyList.pop(), (int) ((Math.random() * (11 - 1)) + 1), privateNames.getName());
        for(int i=0; i< attack; i++)
            createAttackPlayers(jerseyList.pop(), (int) ((Math.random() * (11 - 1)) + 1), privateNames.getName());
        for(int i=0; i< defense; i++)
            createDefensePlayers(jerseyList.pop(), (int) ((Math.random() * (11 - 1)) + 1),privateNames.getName());
        for(int i=0; i< middleFiled; i++)
            createMiddleFiledPlayers(jerseyList.pop(), (int) ((Math.random() * (11 - 1)) + 1), privateNames.getName());
    }
    //=====================================================================================

    public Team(){
        String s = "not supported empty constructor";
        throw new UnsupportedOperationException(s);
    }

//    public  Team (String name, String pathOfNames){
//        this.teamNae = name;
//        this.pathOfNames = pathOfNames;
//    }

//    // need to send txt file with names
//    public static Team crateTeam(String name, String pathOfNames){
//      return new Team(name, pathOfNames);
//    }

    private void createGoalkeepers(int jersey, int grade, String name) {
        FootballPlayer playerGoalkeeper = FootballPlayer.goalKeeperPlayer(jersey, grade, name);
        addPlayer(playerGoalkeeper);
    }

    private void createDefensePlayers( int jersey, int grade, String name) {
        FootballPlayer playerDefense = FootballPlayer.defenderPlayer(jersey, grade, name);
        footballPlayers.add(playerDefense);
    }

    private void createMiddleFiledPlayers(int jersey, int grade, String name) {
        FootballPlayer playerMiddleFiled = FootballPlayer.midfieldPlayer(jersey, grade, name);
        footballPlayers.add(playerMiddleFiled);
    }

    private void createAttackPlayers(int jersey, int grade, String name) {
        FootballPlayer playerAttack = FootballPlayer.attackPlayer(jersey, grade, name);
        addPlayer(playerAttack);
    }
    //=====================================================================================
    private void addPlayer(FootballPlayer player) {
        footballPlayers.add(player);
    }

    public List<FootballPlayer> getFootballPlayers() {
        return footballPlayers;
    }

    public void writeToFile(String name){
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/" + name +"TeamData.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream)) {
            oos.writeObject(this.footballPlayers.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("There was an error - FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("There was an error - IOException");
        }
    }

    @Override
    public String toString() {
        return "Team\n" + footballPlayers+
                ']';
    }

}
