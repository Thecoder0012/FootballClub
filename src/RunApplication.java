import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RunApplication {

    Scanner scanner = new Scanner(System.in);
    FootballPlayer footballPlayer = new FootballPlayer();
    PlayerList playerList = new PlayerList();
    FileHandler fileHandler = new FileHandler();


    public void run() throws IOException {
        fileHandler.populateList(footballPlayer, playerList);
        boolean running = true;
        while (running) {
            playerMenuList();

            switch (scanner.nextInt()) {
                case 1 -> createPlayer();
                case 2 -> playerList.view(playerList);
                case 3 -> editPlayer();
                case 4 -> deletePlayer();
                case 5 -> playerList.sort(Comparator.comparing(FootballPlayer::getName));
                case 6 -> running = false;
                default -> {
                    if (running)
                        System.out.println("try again");
                }
            }
        }
    }

    public void playerMenuList() {
        System.out.println("\n\nEnter:\n***************************************************\n\t" +
                "1 - to create a new player \n\t" +
                "2 - to view players\n\t" +
                "3 - to edit a player\n\t" +
                "4 - to delete a player \n\t" +
                "5 - to sort the players \n\t" +
                "6 - quit the program" +
                "\n***************************************************\n\nEnter your choice:");
    }

    public void createPlayer() throws IOException {
        System.out.println("Type in the name of the player:");
        String name = scanner.next();
        System.out.println("Type in the last name of the player:");
        String lastName = scanner.next();
        System.out.println("Type in the age of the player:");
        int age = scanner.nextInt();
        System.out.println("Type in the name of the player's team?");
        String team = scanner.next();
        playerList.add(new FootballPlayer(name, lastName, age, team));
        fileHandler.savePlayerToFile(playerList);
    }

    public void editPlayer() throws FileNotFoundException {
        System.out.println("Type in an index to edit a player");
        int index = scanner.nextInt();
        System.out.println("Enter new name");
        String newName = scanner.next();
        playerList.get(index).setName(newName);
        System.out.println("Enter new last name");
        String newLastName = scanner.next();
        playerList.get(index).setLastName(newLastName);
        System.out.println("Enter new age");
        int newAge = scanner.nextInt();
        playerList.get(index).setAge(newAge);
        System.out.println("Enter new team");
        String newTeam = scanner.next();
        playerList.get(index).setTeam(newTeam);
        System.out.println();
        playerList.view(playerList);
        FileHandler.updateFile(playerList);

    }

    public void deletePlayer() throws FileNotFoundException {
        System.out.println("Type in an index to delete a player");
        int index = scanner.nextInt();
        playerList.remove(index);
        fileHandler.updateFile(playerList);
    }
}


