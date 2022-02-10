import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class FootballPlayer implements Comparable<FootballPlayer> {

    private String name;
    private String lastName;
    private int age;
    private String team;

    public FootballPlayer(String name, String lastName, int age, String team) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
    }

    public FootballPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String toString(){
        return "\n"+ getClass().getSimpleName()+":"+
       String.format("\nName: %16s \nlastname: %13s \nage: %16d \nteam: %17s", name, lastName, age, team);
    }


    @Override
    public int compareTo(FootballPlayer o) {
        return getName().compareTo(o.getName());
    }
}
