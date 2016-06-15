package One;

import java.util.Scanner;

public class GuessGame {
	public static void main(String[] args) {
		int x = (int) ((Math.random()) * 100);
		for (int i = 5; i > 0; i--) {
			Scanner s = new Scanner(System.in);
			System.out.println("Guess a number between 0 and 100");
			int y = s.nextInt();
			if (y < -10 || y > 110) {
				System.out.println("The number you entered is outside the required range -10 - 1010. Please try again");
			}
			int j = i - 1;
			if (y < (x - 10) || y > (x + 10)) {
				System.out.println("Wrong guess. You have " + j + " tries left");
			} else {
				System.out.println("Congratulations. Your guess was close");
				break;
			}
		}
		System.out.println("Sorry. The correct answer was " + x);
	}
}
