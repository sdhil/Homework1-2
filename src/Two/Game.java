package Two;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		Scanner loop = new Scanner(System.in);
		String ans = "Y";
		while (ans.equalsIgnoreCase("Y")) {
			System.out.println("What is the name of player 1?");
			String p1 = name.nextLine();
			System.out.println("Hello " + p1 + "!");
			System.out.println("What is the name of player 2?");
			String p2 = name.nextLine();
			if (p1.equalsIgnoreCase(p2)) {
				System.out.println("Both players cannot be named " + p1 + ". Enter a different name for player 2: ");
				p2 = name.nextLine();
				System.out.println("Hello " + p2 + "!");
			} else {
				System.out.println("Hello " + p2 + "!");
			}
			System.out.println("How many chips does the initial pile contain?");
			int n = s.nextInt();
			while (n < 3) {
				System.out.println("You have to start with atleast 3 chips. Choose another number");
				n = s.nextInt();
			}
			while (n % 2 == 0) {
				System.out.println("You have to start with an odd number of chips. Choose another number");
				n = s.nextInt();
			}
			int n1 = 0;
			int n2 = 0;
			while (n > 1) {
				System.out.println(p1 + " has " + n1 + " chips.");
				System.out.println(p2 + " has " + n2 + " chips.");
				System.out.println("Its your turn, " + p1);
				System.out.println("There are " + n + " chips remaining.");
				System.out.println("You may take any number of chips from 1 to " + (n / 2)
						+ ". How many will you take, " + p1 + " ?");
				int x = s.nextInt();
				while ((x > (n / 2)) || (x < 1)) {
					System.out.println("Illegal move. You must precisely choose a number from 1 to " + (n / 2));
					x = s.nextInt();
				}
				System.out.println("***************************************************");
				n1 += x;
				n = n - x;
				if (n == 1) {
					System.out.println("The last remaining chip goes to " + p2);
					n2++;
					break;
				}

				System.out.println(p1 + " has " + n1 + " chips.");
				System.out.println(p2 + " has " + n2 + " chips.");
				System.out.println("Its your turn, " + p2);
				System.out.println("There are " + n + " chips remaining.");
				System.out.println("You may take any number of chips from 1 to " + (n / 2)
						+ ". How many will you take, " + p2 + " ?");
				int y = s.nextInt();
				while ((y > (n / 2)) || (y < 1)) {
					System.out.println("Illegal move. You must precisely choose a number from 1 to " + (n / 2));
					y = s.nextInt();
				}
				System.out.println("***************************************************");
				n2 += y;
				n = n - y;
				if (n == 1) {
					System.out.println("The last remaining chip goes to " + p1);
					n1++;
					break;
				}
			}
			System.out.println(p1 + " has " + n1 + " chips.");
			System.out.println(p2 + " has " + n2 + " chips.");
			if (n1 % 2 == 0) {
				System.out.println(p1 + " wins!!!");
			} else {
				System.out.println(p2 + " wins!!!");
			}
			System.out.println("Play another game? (Y/N)");
			ans = loop.nextLine();
		}
	}
}
