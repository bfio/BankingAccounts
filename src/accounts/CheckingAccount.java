package accounts;
import java.math.BigDecimal;

public class CheckingAccount extends Account {

	/**
	 * This penalty constant is applied when making a withdrawal if the account balance is below zero
	 */
	private static final BigDecimal penalty = new BigDecimal(35);
	/**
	 * This limit constant is the minimum balance an account is allowed to reach without throwing an exception
	 */
	private static final BigDecimal limit = new BigDecimal(-5000);

	/**
	 * Constructor. Used to create an account derived from given account information. Goes through superclass for construction.
	 * 
	 * @param accountNumber The number ID on the account
	 * @param accountOwner The person who owns the account
	 * @param accountBalance The dollar balance within the account
	 */
	public CheckingAccount(String accountNumber, String accountOwner, BigDecimal accountBalance) {
		super(accountNumber, accountOwner, accountBalance);
	}
	
	/**
	 * Constructor. Used to create an account derived from a given User object. Goes through superclass for construction.
	 * 
	 * @param user The User associated with the account
	 */
	public CheckingAccount(User user) {
		super(user);
	}

	/**
	 * Used when adding a positive amount of money into an account.
	 * 
	 * @param amount The amount being deposited into the account's balance
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	@Override
	public void deposit(BigDecimal amount) throws InvalidTransactionException {
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new InvalidTransactionException("Cannot deposit negative amount.");
		} else {
			accountBalance = accountBalance.add(amount);
		}
	}
	
	/**
	 * Used when deducting funds from an account's balance.
	 * 
	 * @param amount The amount to be deducted from the account's balance
	 * @throws InvalidTransactionException Thrown when an attempted transaction is invalid
	 */
	@Override
	public void withdraw(BigDecimal amount) throws InvalidTransactionException {
		accountBalance = accountBalance.subtract(amount);
		if (accountBalance.compareTo(BigDecimal.ZERO) == -1) {
			System.out.println("Account overdrawn. $35 charge being assessed.");
			accountBalance = accountBalance.subtract(penalty);	
		}
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			throw new InvalidTransactionException("Cannot withdraw negative amount.");
		} 
		if (accountBalance.compareTo(limit) == -1) {
			throw new InvalidTransactionException("Overdraft limit (" + limit.toPlainString() + ") reached.");
		}
	}
}