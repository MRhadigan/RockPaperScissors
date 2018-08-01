package RockPaperScissors;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {

		// declare and initialize variable
		Scanner scan = new Scanner(System.in);
		String cont;
		Player human = new User();
		Player computer = null;
		String userName;
		String userChoice;
		String userInput;
		Roshambo value = null;
		Roshambo userValue;

			// Prompt user to enter name. Validate input
			userName = Validator.getString(scan, "Please anter a name: ");
			human.setName(userName);
			do {
			// prompt user to select opponent. Validate input
			userChoice = Validator.getString(scan, "Would you like to play against The Jets or The Sharks? (j/s)");

			// prompt user to select rock, paper, scissors. Validate input
			userInput = Validator.getString(scan, "Rock, Paper, or Scissors? (R/P/S)");

			// Display opponents choice
			if (userChoice.equalsIgnoreCase("j")) {
				computer = new Dummy();
				computer.setName("The Jets");
				value = computer.generateRoshambo();
				System.out.println("The Jets chose: " + value);
			} else if (userChoice.equalsIgnoreCase("s")) {
				computer = new RandomUser();
				computer.setName("The Sharks");
				value = computer.generateRoshambo();
				System.out.println("The Sharks chose: " + value);
			}

			// Display user's choice
			userValue = human.generateRoshambo(userInput);
			System.out.println(userName + " you chose: " + human.generateRoshambo(userInput));

			// Display results of match. Write a seperate method
			System.out.println(displayResults(computer, human, userValue, value));

			// prompt user to continue. Validate input

			System.out.println("Would you like to continue? (y/n):");
			cont = scan.next();

		} while (cont.equalsIgnoreCase("y"));

		System.out.println("Goodbye!");

		scan.close();
	}

	public static String displayResults(Player computer, Player human, Roshambo userValue, Roshambo value) {
		if (userValue == value) {
			return "It's a Draw!";
		} else if (userValue == Roshambo.ROCK && value == Roshambo.PAPER
				|| userValue == Roshambo.PAPER && value == Roshambo.SCISSORS
				|| userValue == Roshambo.SCISSORS && value == Roshambo.ROCK) {
			return computer.getName() + " Wins!!!";
		} else {
			return human.getName() + " Wins!!!";
		}

	}
}
