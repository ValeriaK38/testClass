package org.example;

public class FootballPlayer {

    private String name; // real name
    private int jersey; //unique
    private Posiotion position;
    private int grade; // random in range of 1 - 10


    private FootballPlayer(String name, int jersey, Posiotion position, int grade) {
        this.name = name;
        this.jersey = jersey;
        this.position = position;
        this.grade = grade;
    }

    //----------------------------------------------------------------
    public static FootballPlayer goalKeeperPlayer(int jersey, int grade, String name){
        return new FootballPlayer(name, jersey, Posiotion.GOALKEEPER, grade);
    }

        public static FootballPlayer attackPlayer(int jersey, int grade, String name){
            return new FootballPlayer(name, jersey, Posiotion.ATTACKER, grade);
    }

    public static FootballPlayer defenderPlayer(int jersey, int grade, String name){
        return new FootballPlayer(name, jersey, Posiotion.DEFENDER, grade);
    }

    public static FootballPlayer midfieldPlayer(int jersey, int grade, String name){
        return new FootballPlayer(name, jersey, Posiotion.MIDFIELDER, grade);
    }
//----------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJersey() {
        return jersey;
    }

    public void setJersey(int jersey) {
        this.jersey = jersey;
    }

    public Posiotion getPosition() {
        return position;
    }

    public void setPosition(Posiotion position) {
        this.position = position;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[" +
                "name= " + name +
                ", jersey= " + jersey +
                ", position= " + position +
                ", grade= " + grade +
                ']' + "\n";
    }
}
