import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreBoardX {

    // Inner class: Team
    static class Team {
        private String name;
        private int score;

        public Team(String name) {
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void addPoints(int points) {
            this.score += points;
        }

        public void resetScore() {
            this.score = 0;
        }
    }

    // Inner class: ScoreBoard
    static class ScoreBoard {
        private List<Team> teams;

        public ScoreBoard() {
            teams = new ArrayList<>();
        }

        public void addTeam(String teamName) {
            teams.add(new Team(teamName));
            System.out.println("✅ Added team: " + teamName);
        }

        public void updateScore(String teamName, int points) {
            for (Team team : teams) {
                if (team.getName().equalsIgnoreCase(teamName)) {
                    team.addPoints(points);
                    System.out.println("✅ Updated " + teamName + " score by " + points + " points.");
                    return;
                }
            }
            System.out.println("⚠️ Team not found: " + teamName);
        }

        public void displayScores() {
            System.out.println("\n🏆 Current Scoreboard:");
            for (Team team : teams) {
                System.out.println("- " + team.getName() + ": " + team.getScore() + " points");
            }
            System.out.println();
        }

        public void resetAllScores() {
            for (Team team : teams) {
                team.resetScore();
            }
            System.out.println("✅ All scores have been reset.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScoreBoard scoreboard = new ScoreBoard();

        System.out.println("🎯 Welcome to ScoreBoardX!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Team");
            System.out.println("2. Update Team Score");
            System.out.println("3. Display Scores");
            System.out.println("4. Reset All Scores");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter team name: ");
                    String teamName = scanner.nextLine();
                    scoreboard.addTeam(teamName);
                    break;
                case 2:
                    System.out.print("Enter team name: ");
                    String teamToUpdate = scanner.nextLine();
                    System.out.print("Enter points to add: ");
                    int points = scanner.nextInt();
                    scoreboard.updateScore(teamToUpdate, points);
                    break;
                case 3:
                    scoreboard.displayScores();
                    break;
                case 4:
                    scoreboard.resetAllScores();
                    break;
                case 5:
                    System.out.println("👋 Exiting ScoreBoardX. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again!");
            }
        }
    }
}

