
import java.util.ArrayList;
import java.util.Scanner;

class Candidate {
    String name;
    int votes;

    Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    void addVote() {
        votes++;
    }

    void display() {
        System.out.println(name + " : " + votes + " votes");
    }
}

public class StudentCouncilElection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Candidate> candidates = new ArrayList<>();

        try {
            System.out.print("Enter number of candidates: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n <= 0) {
                System.out.println("Invalid number of candidates.");
                return;
            }

            // Enter candidate names
            for (int i = 0; i < n; i++) {
                System.out.print("Enter candidate " + (i + 1) + " name: ");
                String name = sc.nextLine();

                candidates.add(new Candidate(name));
            }

            System.out.print("Enter number of voters: ");
            int voters = sc.nextInt();

            if (voters < 0) {
                System.out.println("Invalid number of voters.");
                return;
            }

            // Record votes
            for (int i = 0; i < voters; i++) {
                System.out.println("\nCandidates:");

                for (int j = 0; j < candidates.size(); j++) {
                    System.out.println((j + 1) + ". "
                            + candidates.get(j).name);
                }

                System.out.print("Voter " + (i + 1)
                        + ", enter your choice: ");
                int choice = sc.nextInt();

                if (choice >= 1 && choice <= candidates.size()) {
                    candidates.get(choice - 1).addVote();
                    System.out.println("Vote recorded successfully.");
                } else {
                    System.out.println("Invalid choice. Vote not recorded.");
                }
            }

            // Display election results
            System.out.println("\n--- Election Results ---");

            int highestVotes = -1;

            for (Candidate c : candidates) {
                c.display();

                if (c.votes > highestVotes) {
                    highestVotes = c.votes;
                }
            }

            // Find winner or tie
            ArrayList<String> winners = new ArrayList<>();

            for (Candidate c : candidates) {
                if (c.votes == highestVotes) {
                    winners.add(c.name);
                }
            }

            if (winners.size() == 1) {
                System.out.println("Winner: " + winners.get(0));
            } else {
                System.out.println("Election tied between: " + winners);
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numbers correctly.");
        } finally {
            sc.close();
        }
    }
}
