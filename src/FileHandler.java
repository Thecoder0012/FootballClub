import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static void updateFile(PlayerList playerList) throws FileNotFoundException {
        String output = "";
        File file = new File("players.txt");
        PrintStream printStream = new PrintStream(file);
        for (int i = 0; i < playerList.size(); i++) {
            output += playerList.get(i).getName() + " / " + playerList.get(i).getLastName()
                    + " / " + playerList.get(i).getAge()
                    + " / " + playerList.get(i).getTeam() + "\n";
        }
        printStream.append(output);
        printStream.close();
    }

    public static void populateList(FootballPlayer player, PlayerList playerList) throws IOException {
        File br = new File("players.txt");
        Scanner scanner = new Scanner(br);
        while (scanner.hasNext()) {
            String[] part = scanner.nextLine().split(" / ");
            player = new FootballPlayer(part[0], part[1], (Integer.parseInt(part[2])), ((part[3])));
            playerList.add(player);
        }
    }

    public void saveToFile(String name, String lastName, int age, String team) throws IOException {
        FileWriter fileWriter = new FileWriter("players.txt", true);
        fileWriter.append(name + " / " + lastName + " / " + age + " / " + team);
        fileWriter.close();


    }
    public void savePlayerToFile(PlayerList playerList) throws IOException {
        String output = "";
        FileWriter fileWriter = new FileWriter("players.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int studentIndex = playerList.size() - 1;
        output += playerList.get(studentIndex).getName() + " / " + playerList.get(studentIndex).getLastName()
                + " / " + playerList.get(studentIndex).getAge() + " / " +
                playerList.get(studentIndex).getTeam() + "\n";
        bufferedWriter.write(output);
        bufferedWriter.close();
        fileWriter.close();
    }
}
