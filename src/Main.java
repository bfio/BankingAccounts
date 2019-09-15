
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static Scanner s;
	public static Account acc;
	public static String num;
	public static String owner;
	public static BigDecimal bal;
	public static BigDecimal limit;

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		//Get user details
		System.out.print("Enter account number: ");
		num = s.nextLine();
		System.out.print("Enter account owner: ");
		owner = s.nextLine();
		System.out.print("Enter starting account balance: ");
		bal = BigDecimal.valueOf(s.nextLong());
		System.out.print("Enter overdraw limit: ");
		limit = BigDecimal.valueOf(s.nextLong());
		System.out.println("");

		char input = ' ';
		while (input != 'E') {
			System.out.println("--> To exit, enter [E] <--");
			System.out.print("Select Savings [S] or Checking [C]: ");
			input = s.next().charAt(0);
			if (input == 'S') {
				acc = new SavingsAccount(num, owner, bal, limit);
				acc.printBalance();
			} else if (input == 'C') {
				//Checking account
				acc = new CheckingAccount(num, owner, bal);
				acc.printBalance();
			} else if (input == 'E') {
				break;
			} else {
				throw new Exception(
						"Invalid input. Please enter [S], [C], or [E] to exit");
			}
			while (input != 'B') {
				System.out.println("--> To go back, enter [B] <--");
				System.out.print("Deposit [D] or Withdrawal [W]?: ");
				input = s.next().charAt(0);
				if (input == 'D') {
					System.out.print("Enter deposit amount: ");
					acc.deposit(BigDecimal.valueOf(s.nextLong()));
				} else if (input == 'W') {
					System.out.print("Enter withdrawal amount: ");
					acc.withdraw(BigDecimal.valueOf(s.nextLong()));
				} else if (input == 'B') {
					break;
				} else {
					throw new Exception(
							"Invalid input. Please enter [D], [W], [B] to go back, or [E] to exit");
				}
			}
		}

		s.close();
	}

}
