package week5;
import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    // Encapsulation
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    // Overloaded method 1
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Overloaded method 2
    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // compareTo is used by Arrays.sort()
    @Override
    public int compareTo(Player other) {

        return Double.compare(
                other.getBattingAverage(),
                this.getBattingAverage()
        );
    }

    // Draft and rank players
    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].getMatchesPlayed())
                    || isDraftable(
                    players[i].getMatchesPlayed(),
                    players[i].isInjured())) {

                draftable[count] = players[i];
                count++;
            }
        }

        // Remove unused empty positions
        Player[] finalList = Arrays.copyOf(draftable, count);

        // Uses compareTo()
        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + finalList[i].getName();

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }
}

public class PlayerRanking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            sc.nextLine();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }

        String result = Player.draftAndRank(players);

        System.out.println("\nDraft Ranking:");
        System.out.println(result);

        sc.close();
    }
}