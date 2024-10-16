import java.util.*;



public class IceCreamVoting {

    public static void main(String[] args) {
        Set<String> flavors = new HashSet<>();
        flavors.add("Vanilla");
        flavors.add("Chocolate");
        flavors.add("Strawberry");
        flavors.add("Coffee");
        flavors.add("Cookies and Cream");

        Map<String, Integer> voteCount = new HashMap<>();

        List<String> familyMembers = new ArrayList<>(Arrays.asList("Hector", "Emily", "Lyla", "Melanie", "Alice"));

        System.out.println("Available flavors to vote for:");
        printFlavorOptions(flavors);

        collectVotes(familyMembers, flavors, voteCount);

        displayTopFlavor(voteCount);
    }

    public static void printFlavorOptions(Set<String> flavors) {
        for (String flavor : flavors) {
            System.out.println("- " + flavor);
        }
    }

    public static void collectVotes(List<String> familyMembers, Set<String> flavors, Map<String, Integer> voteCount) {
        Scanner scanner = new Scanner(System.in);

        for (String member : familyMembers) {
            String chosenFlavor = null;
            boolean validInput = false;

            while (!validInput) {
                System.out.println(member + ", which flavor would you like to vote for?");
                chosenFlavor = scanner.nextLine().trim();

                if (flavors.contains(chosenFlavor)) {
                    validInput = true; // Input is valid
                } else {
                    System.out.println("Invalid flavor! Please choose a flavor from the list.");
                    printFlavorOptions(flavors); // Print the options again
                }
            }

            voteCount.put(chosenFlavor, voteCount.getOrDefault(chosenFlavor, 0) + 1);
        }
    }

    public static void displayTopFlavor(Map<String, Integer> voteCount) {
        int maxVotes = 0;
        for (int count : voteCount.values()) {
            if (count > maxVotes) {
                maxVotes = count; // Find the maximum vote count
            }
        }

        List<String> topFlavors = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() == maxVotes) {
                topFlavors.add(entry.getKey());
            }
        }

        System.out.println("The top flavor(s) with " + maxVotes + " vote(s):");
        for (String flavor : topFlavors) {
            System.out.println("- " + flavor);
        }
    }
}
