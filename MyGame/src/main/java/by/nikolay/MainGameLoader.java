package by.nikolay;

import java.util.Scanner;

public class MainGameLoader {
    private WordCollections wordCollections;
    private BullsAndCows bullsAndCows;
    private Scanner scanner;

    public void run() {
        System.out.println("Do you want to play this game?");
        System.out.println("Yes(y) or No(n)");
		String userIn = new Scanner(System.in).nextLine();
        if (userIn.toLowerCase().equals("y")) {

            System.out.println("Load game Cows and Bulls");
            startGame();
        } else {
            endGame();
        }
    }

    private void startGame() {
        int count = 0;
        wordCollections = new WordCollections();
        bullsAndCows = new BullsAndCows(0, 0);
        scanner = new Scanner(System.in);
        String randomWord = wordCollections.getRandomWord();
        System.out.println("Word is selected");
        System.out.println("TIP: The word consist of " + randomWord.length() + " character.");
        
        while (count < 100) {
            String input = scanner.nextLine();

            if (randomWord.equals(input)) {
                winGame();
                return;
            }

            for (int i = 0; i < randomWord.length(); i++) {

                for (int j = 0; j < input.length(); j++) {

                    if (randomWord.charAt(i) == input.charAt(j)) {

                        if (i == j) {

                            bullsAndCows.setBulls(bullsAndCows.getBulls() + 1);
                        } else {
                            bullsAndCows.setCows(bullsAndCows.getCows() + 1);
                        }
                    }
                }
            }

            System.out.println("Cows: " + bullsAndCows.getCows());
            System.out.println("Bulls: " + bullsAndCows.getBulls());
            bullsAndCows.reset();
            count++;
        }
        System.out.println("The guess word is " + randomWord);
        loseGame();
        return;
    }

    private void endGame() {
        System.out.println("Good bue");
    }

    private void winGame() {
        bullsAndCows.reset();
        System.out.println("You win. Congratulation");
        run();
    }

    private void loseGame() {
        bullsAndCows.reset();
        System.out.println("You are lose");
        run();
    }

}
